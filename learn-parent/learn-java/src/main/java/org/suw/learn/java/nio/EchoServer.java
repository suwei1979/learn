/*
 * Copyright (C) 2018 Wei Su(suwei1979@139.com). All Rights Reserved.
 */

package org.suw.learn.java.nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 */
public class EchoServer {
    private static final int ECHO_SERVER_PORT = 6789;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(ECHO_SERVER_PORT)) {
            System.out.println("服务器已经启动...");
            while (true) {
                Socket client = server.accept();
                new Thread(new ClientHandler(client)).start();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket client;

        public ClientHandler(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            try (InputStream is = client.getInputStream();
                 InputStreamReader ir = new InputStreamReader(is);
                 BufferedReader br = new BufferedReader(ir);
                 PrintWriter pw = new PrintWriter(client.getOutputStream())) {

                String message = br.readLine();
                System.out.println("收到" + client.getInetAddress() + "发送的：" + message);
                pw.println(message);
                pw.flush();

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    client.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}

