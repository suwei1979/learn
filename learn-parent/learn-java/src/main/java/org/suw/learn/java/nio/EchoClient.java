/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */

package org.suw.learn.java.nio;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {
    public static void main(String[] args) throws Exception {
        Socket client = new Socket("localhost", 6789);
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入内容：");
        String msg = sc.nextLine();
        sc.close();

        PrintWriter pw = new PrintWriter(client.getOutputStream());

        pw.println(msg);
        pw.flush();
        BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
        System.out.println(br.readLine());
        client.close();
    }

}
