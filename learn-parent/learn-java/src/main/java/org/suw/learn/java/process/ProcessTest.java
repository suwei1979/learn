/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.java.process;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import org.apache.log4j.Logger;

public class ProcessTest {
    private static final Logger logger = Logger.getLogger(ProcessTest.class);

    public static void main(String[] args) throws Exception {
        String cmd = "./testshell";
        Process process = Runtime.getRuntime().exec(cmd);
        int exitCode = process.waitFor();
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String shellResult = "";
        if (logger.isDebugEnabled()) {
            String shellOutput = reader.readLine();
            while (shellOutput != null && !"".equals(shellOutput.trim())) {
                // Take the latest output as result;
                shellResult = shellOutput;
                shellOutput = reader.readLine();
            }
        }

        logger.info("The result is: " + shellResult);
        logger.info("The exit code is: " + exitCode + "");
        setContext(shellResult);
    }

    private static void setContext(String shellResult) {
        StringTokenizer tokenizer = new StringTokenizer(shellResult, ";");
        while (tokenizer.hasMoreTokens()) {
            String keyValuePair = tokenizer.nextToken().trim();
            String key = keyValuePair.substring(0, keyValuePair.indexOf("="));
            String value = keyValuePair.substring(keyValuePair.indexOf("=") + 1, keyValuePair.length());
            logger.debug(key + "=" + value);
        }
    }
}
