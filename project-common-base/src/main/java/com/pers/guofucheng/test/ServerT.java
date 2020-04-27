package com.pers.guofucheng.test;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ServerT {

    public static void main(String[] args) {
        try {
            ServerSocketChannel serverChannel = ServerSocketChannel.open();
            serverChannel.bind(new InetSocketAddress(9898));
            SocketChannel accept = serverChannel.accept();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            FileChannel fileChannel = FileChannel.open(Paths.get("MyApplication2.java"),
                    StandardOpenOption.WRITE,  StandardOpenOption.CREATE);
            if (accept.read(byteBuffer) != 1) {
                byteBuffer.flip();
                fileChannel.write(byteBuffer);
                byteBuffer.clear();
            }
            accept.close();
            serverChannel.close();
            fileChannel.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
