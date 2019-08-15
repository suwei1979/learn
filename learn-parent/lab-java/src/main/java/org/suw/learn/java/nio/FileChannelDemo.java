/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */

package org.suw.learn.java.nio;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelDemo {

    public static void main(String[] args) throws Exception {
        File file = new File("data/nio-data.txt");
        System.out.println(file.getAbsolutePath());
        RandomAccessFile aFile = new RandomAccessFile("data/nio-data.txt", "rw");

        FileChannel inChannel = aFile.getChannel();

        ByteBuffer buf = ByteBuffer.allocate(48);
        System.out.println("Buffer property after allocate: ");
        System.out.println("buf.capacity() = " + buf.capacity());
        System.out.println("buf.position() = " + buf.position());
        System.out.println("buf.limit() = " + buf.limit());
        System.out.println();

        int bytesRead = inChannel.read(buf);
        System.out.println("Buffer property after read: ");
        System.out.println("buf.capacity() = " + buf.capacity());
        System.out.println("buf.position() = " + buf.position());
        System.out.println("buf.limit() = " + buf.limit());
        System.out.println();

        while (bytesRead != -1) {

            System.out.println("Read " + bytesRead + " bytes of data.");
            buf.flip();
            System.out.println("Buffer property after flip is: ");
            System.out.println("buf.capacity() = " + buf.capacity());
            System.out.println("buf.position() = " + buf.position());
            System.out.println("buf.limit() = " + buf.limit());
            System.out.println();

            while (buf.hasRemaining()) {
                System.out.print((char) buf.get());
            }
            System.out.println();
            System.out.println();

            System.out.println("Buffer property after get is: ");
            System.out.println("buf.capacity() = " + buf.capacity());
            System.out.println("buf.position() = " + buf.position());
            System.out.println("buf.limit() = " + buf.limit());
            System.out.println();
            buf.clear();

            System.out.println("Buffer property after clear is: ");
            System.out.println("buf.capacity() = " + buf.capacity());
            System.out.println("buf.position() = " + buf.position());
            System.out.println("buf.limit() = " + buf.limit());
            System.out.println();
            bytesRead = inChannel.read(buf);

            System.out.println("Buffer property after read: ");
            System.out.println("buf.capacity() = " + buf.capacity());
            System.out.println("buf.position() = " + buf.position());
            System.out.println("buf.limit() = " + buf.limit());
            System.out.println();
        }

        aFile.close();
    }
}
