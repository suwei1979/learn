/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.interview;

import java.util.HashMap;

/**
 * TwoNumberSum
 * 两数相加，解法有三
 * 1. 双循环
 * 2. 两遍哈希
 * 3. 一遍哈希
 *
 * @author suwei
 * @since 2019/8/12 : 12:54 PM
 **/
public class TwoNumberSum {
    public int[] twoSumWith2Loop(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    int[] result = new int[2];
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }

        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public int[] twoSumWithHash(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.get(complement) != null) {
                return new int[] {map.get(complement), i};
            }
            map.putIfAbsent(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] nums = {7, 11, 15, 2, 7, 2};
        int target = 15;
        int[] result = new TwoNumberSum().twoSumWith2Loop(nums, target);
        int[] result1 = new TwoNumberSum().twoSumWithHash(nums, target);
        System.out.println("[" + result[0] + ", " + result[1] + "]");
        System.out.println("[" + result1[0] + ", " + result1[1] + "]");
    }
}
