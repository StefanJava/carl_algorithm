package com.stefan.array.niodemo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class NioClient {

    private final List<String> responseQueue = new ArrayList<>();
    private SocketChannel clientSocketChannel;
    private Selector selector;
    private CountDownLatch connected = new CountDownLatch(1);

    public NioClient() throws IOException, InterruptedException {
        // 打开ClientSocketChannel
        clientSocketChannel = SocketChannel.open();
        // 配置为非阻塞
        clientSocketChannel.configureBlocking(false);
        // 创建 Selector
        selector = Selector.open();
        // 注册 ClientSocketChannel 到 Selector
        clientSocketChannel.register(selector, SelectionKey.OP_CONNECT);
        // 连接服务器
        clientSocketChannel.connect(new InetSocketAddress(9000));

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    handleKeys();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

        if (connected.getCount() != 0) {
            connected.await();
        }

        System.out.println("Client 启动完成");
    }

    private void handleKeys() throws IOException {
        while (true) {
            // 通过 Selector 选择 Channel
            int selectNums = selector.select(30 * 1000L);
            if (selectNums == 0) {
                continue;
            }

            // 遍历可选择的 Channel 的 SelectionKey 集合
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                iterator.remove();
                if (!key.isValid()) {
                    continue;
                }

                handleKey(key);
            }
        }
    }

    private synchronized void handleKey(SelectionKey key) throws IOException {
        // 接受连接就绪
        if (key.isConnectable()) {
            handleConnectableKey(key);
        }
        // 读就绪
        if (key.isReadable()) {
            handleReadableKey(key);
        }
        // 写就绪
        if (key.isWritable()) {
            handleWritableKey(key);
        }
    }

    private void handleConnectableKey(SelectionKey key) throws IOException {
        // 完成连接
        if (!clientSocketChannel.isConnectionPending()) {
            return;
        }
        clientSocketChannel.finishConnect();
        // log
        System.out.println("接受新的 Channel");
        // 注册 ClientSocketChannel 到 Selector
        clientSocketChannel.register(selector, SelectionKey.OP_READ, responseQueue);
        // 标记为已连接
        connected.countDown();
    }

    private void handleReadableKey(SelectionKey key) {
        // Client Socket Channel
        SocketChannel clientSocketChannel = (SocketChannel) key.channel();
        // 读取数据
        ByteBuffer readBuffer = CodecUtil.read(clientSocketChannel);
        // 打印数据
        if (readBuffer.position() > 0) {
            String content = CodecUtil.newString(readBuffer);
            System.out.println("读取数据：" + content);
        }
    }

    private void handleWritableKey(SelectionKey key) throws ClosedChannelException {
        // Client Socket Channel
        SocketChannel clientSocketChannel = (SocketChannel) key.channel();

        // 遍历响应队列
        List<String> responseQueue = (List<String>) key.attachment();
        if (responseQueue != null) {
            for (String content : responseQueue) {
                // 打印数据
                System.out.println("写入数据：" + content);
                // 返回
                CodecUtil.write(clientSocketChannel, content);
            }
            responseQueue.clear();
        } else {
            responseQueue = new ArrayList<>();
        }

        // 注册 Client Socket Channel 到 Selector
        clientSocketChannel.register(selector, SelectionKey.OP_READ, responseQueue);
    }

    public synchronized void send(String content) throws ClosedChannelException {
        // 添加到响应队列
        responseQueue.add(content);
        // 打印数据
        System.out.println("写入数据：" + content);
        // 注册 Client Socket Channel 到 Selector
        clientSocketChannel.register(selector, SelectionKey.OP_WRITE, responseQueue);
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        NioClient client = new NioClient();
        for (int i = 0; i < 30; i++) {
            client.send("nihao: " + i);
            TimeUnit.SECONDS.sleep(1);
        }
    }

}
