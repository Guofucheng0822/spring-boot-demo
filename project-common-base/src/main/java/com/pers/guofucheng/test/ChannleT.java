package com.pers.guofucheng.test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ChannleT {


    public static void main(String[] args) throws IOException {

        //拿到 Socket 信道
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));
        //拿到 FileChannel
        FileChannel fileChannel = FileChannel.open(Paths.get("MyApplication1.java"),
                StandardOpenOption.READ);
        ByteBuffer allocate = ByteBuffer.allocate(1024);
        while (fileChannel.read(allocate) != -1) {
            allocate.flip();
            socketChannel.write(allocate);
            allocate.clear();
        }
        fileChannel.close();
        socketChannel.close();
    }

}
