/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.interview;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

import org.suw.learn.algorithm.Sort;

/**
 * LengthOfSubstring
 *
 * @author suwei
 * @since 2019/8/19 : 3:50 PM
 **/
public class LengthOfSubstring {
    public int lengthOfLongestSubstring(String s) {
        String[] data = split(s);
        return sort(data)[0].length();
    }

    private String[] sort(String[] data) {
        return Sort.byBubble(data);
    }

    private String[] split(String s) {
        return split(s, 0);
    }

    private String[] split(String s, int start) {
        char c;
        StringBuffer splited = new StringBuffer();
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = start; i < s.length(); i++) {
            c = s.charAt(i);
            map.putIfAbsent(c, i);
            int pos = map.getOrDefault(c, i);
            if (pos != i) {
                map.keySet().forEach(character -> splited.append(character));
                break;
            }
        }
        String[] result;
        if (start < s.length() - 1) {
            String[] recursiveResult = split(s, start + 1);
            result = Arrays.copyOf(recursiveResult, recursiveResult.length + 1);
            result[result.length -1] = splited.toString();
        } else {
            result = new String[] {splited.toString()};
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";

        //        String[] data = {"abc", "cd", "a", "ab", "abcd"};
        LengthOfSubstring lengthOfSubstring = new LengthOfSubstring();
        String[] data = lengthOfSubstring.split(s);
//        lengthOfSubstring.sort(data);
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i]);
        }
        //        System.out.println(new LengthOfSubstring().lengthOfLongestSubstring(s));
    }
}
