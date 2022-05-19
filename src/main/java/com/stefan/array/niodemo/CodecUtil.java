package com.stefan.array.niodemo;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

public class CodecUtil {
    public static ByteBuffer read(SocketChannel clientSocketChannel) {

        // 注意，不考虑拆包的处理
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        try {
            int count = clientSocketChannel.read(buffer);
            if (count == -1) {
                return null;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return buffer;
    }

    public static String newString(ByteBuffer readBuffer) {

        readBuffer.flip();
        byte[] bytes = new byte[readBuffer.remaining()];
        System.arraycopy(readBuffer.array(), readBuffer.position(), bytes, 0, readBuffer.remaining());
        try {
            return new String(bytes, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void write(SocketChannel clientSocketChannel, String content) {
        // 写入Buffer
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put(content.getBytes(StandardCharsets.UTF_8));
        // 写入Channel
        buffer.flip();
        // 注意，不考虑写入超过Channel缓存区上限
        try {
            clientSocketChannel.write(buffer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
