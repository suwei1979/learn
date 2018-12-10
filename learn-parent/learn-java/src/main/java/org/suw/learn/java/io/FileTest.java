/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.java.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class FileTest {
    private FileTest() {
        throw new AssertionError();
    }

    public static void fileCopy(String source, String target) throws IOException {
        try (InputStream in = new FileInputStream(source)) {
            try (OutputStream out = new FileOutputStream(target)) {
                byte[] buffer = new byte[4096];
                int bytesToRead;
                while ((bytesToRead = in.read(buffer)) != -1) {
                    out.write(buffer, 0, bytesToRead);
                }
            }
        }
    }

    public static void fileCopyNIO(String source, String target) throws IOException {
        try (FileInputStream in = new FileInputStream(source)) {
            try (FileOutputStream out = new FileOutputStream(target)) {
                FileChannel inChannel = in.getChannel();
                FileChannel outChannel = out.getChannel();
                ByteBuffer buffer = ByteBuffer.allocate(4096);
                while (inChannel.read(buffer) != -1) {
                    buffer.flip();
                    outChannel.write(buffer);
                    buffer.clear();
                }
            }
        }
    }

    public static int countWordInFile(String fileName, String word) {
        int counter = 0;

        try (FileReader fr = new FileReader(fileName)) {
            try (BufferedReader bufferedReader = new BufferedReader(fr)) {
                String line = null;
                while ((line = bufferedReader.readLine()) != null) {
                    int index = -1;
                    while (line.length() >= word.length() && (index = line.indexOf(word)) >= 0) {
                        counter++;
                        line = line.substring(index + word.length());
                    }
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return counter;
    }

    public static void listAll(String dir, String printPrefix) {
        File file = new File(dir);
        for (File f : file.listFiles()) {
            if (f.isFile()) {
                System.out.println(f.getName());
            }
        }
    }

    public static void listAll(String dir, String printPrefix, boolean recursively) throws IOException {
        Path initPath = Paths.get(dir);
        Files.walkFileTree(initPath, new SimpleFileVisitor<Path>() {

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println(file.getFileName().toString());
                return FileVisitResult.CONTINUE;
            }

        });
    }

    public static void main(String[] args) throws Exception {
        System.out.println("output of filecopy test: ");
        fileCopy("./pom.xml", "pom-copy.xml");
        System.out.println();

        System.out.println("output of filecopy with nio test: ");
        fileCopy("./pom.xml", "pom-copy-nio.xml");
        System.out.println();

        System.out.println("output of listAll: ");
        listAll(".", "--");
        System.out.println();

        System.out.println("output of listAll recursively: ");
        listAll(".", "", true);
    }
}
