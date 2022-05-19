package com.stefan.array.niodemo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NioServer {

    private ServerSocketChannel serverSocketChannel;
    private Selector selector;

    public NioServer() throws IOException {
        // 打开ServerSocketChannel
        serverSocketChannel = ServerSocketChannel.open();
        // 配置为非阻塞
        serverSocketChannel.configureBlocking(false);
        // 绑定Server Port
        serverSocketChannel.bind(new InetSocketAddress(9000));
        // 创建Selector
        selector = Selector.open();
        // 注册ServerSocketChannel到Selector
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("Server 启动完成");

        handleKeys();
    }

    private void handleKeys() throws IOException {
        while (true) {
            // 通过Selector选择Channel
            int selectNums = selector.select(30 * 1000L);
            if (selectNums == 0) {
                continue;
            }
            System.out.println("选择 Channel 数量: " + selectNums);

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

    private void handleKey(SelectionKey key) throws IOException {
        // 接受连接就绪
        if (key.isAcceptable()) {
            handleAcceptableKey(key);
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

    private void handleAcceptableKey(SelectionKey key) throws IOException {
        // 接受ClientSocketChannel
        SocketChannel clientSocketChannel = ((ServerSocketChannel) key.channel()).accept();
        // 配置为非阻塞
        clientSocketChannel.configureBlocking(false);
        // log
        System.out.println("接受新的 Channel");
        // 注册ClientSocketChannel到Selector
        clientSocketChannel.register(selector, SelectionKey.OP_READ, new ArrayList<String>());
    }

    private void handleReadableKey(SelectionKey key) throws ClosedChannelException {
        // ClientSocketChannel
        SocketChannel clientSocketChannel = (SocketChannel) key.channel();
        // 读取数据
        ByteBuffer readBuffer = CodecUtil.read(clientSocketChannel);
        // 处理连接已经断开的情况
        if (readBuffer == null) {
            System.out.println("断开 Channel");
            clientSocketChannel.register(selector, 0);
            return;
        }
        // 打印数据
        if (readBuffer.position() > 0) {
            String content = CodecUtil.newString(readBuffer);
            System.out.println("读取数据: " + content);

            // 添加到响应队列
            List<String> responseQueue = (List<String>) key.attachment();
            responseQueue.add("响应：" + content);
            // 注册ClientSocketChannel到Selector
            clientSocketChannel.register(selector, SelectionKey.OP_WRITE);
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

        // 注册ClientSocketChannel到Selector
        clientSocketChannel.register(selector, SelectionKey.OP_READ, responseQueue);
    }


    public static void main(String[] args) throws IOException {
        NioServer server = new NioServer();
    }
}
