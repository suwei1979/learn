/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.java.nio;

import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class TransferBetweenChannel {

    public static void main(String[] args) throws Exception {
        RandomAccessFile fromFile = new RandomAccessFile("data/fromFile.txt", "rw");
        FileChannel fromChannel = fromFile.getChannel();

        RandomAccessFile toFile = new RandomAccessFile("data/toFile.txt", "rw");
        FileChannel toChannel = toFile.getChannel();

        long position = 0;
        long count = fromChannel.size();

        toChannel.transferFrom(fromChannel, position, count);

    }

}
