/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.java.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * RegularExpression
 *
 * @author suwei
 * @since 2019/7/9 : 5:37 PM
 **/
public class RegularExpression {
    public static void main(String... args) {
        String template = "map ${nginx_env_variable:default} $remote_origin_addr {" + "\n" +
                "\tdefault ${nginx_env_remote_address}; " + "\n" +
                "\t~^(?P<firstAddr>[0-9\\.]+),?.*$ $firstAddr;" + "\n" +
                "}";
//        TemplateDirectiveDescriptor tdd = new TemplateDirectiveDescriptor("", template);
//        tdd.getParams().forEach(paramDescriptor -> System.out.println("paramDescriptor = " + paramDescriptor));

        Pattern pattern = Pattern.compile("\\$\\{(\\w+)(:(\\w+))?\\}");
        Matcher matcher = pattern.matcher(template);
        System.out.println("original: " + template);
        System.out.println("pattern : " + pattern.toString());
        System.out.println("groupcnt: " + matcher.groupCount());

        while (matcher.find()) {
            for (int i = 0; i <= matcher.groupCount(); i++) {
                System.out.println("group" + i + ": " + matcher.group(i));
            }
        }
        System.out.println("replaced: " + matcher.replaceAll("$http_x_forward_for".replace("$", "\\$")));

    }

}
