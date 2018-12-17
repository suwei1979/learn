/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.java.algorithm;

public class FindDuplicate {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        int length = 7;
        int[] duplication = new int[length];
        FindDuplicate findDuplicate = new FindDuplicate();
        findDuplicate.duplicate(nums, length, duplication);

        for (int i = 0; i < duplication.length; i++) {
            if (duplication[i] != 0) {
                System.out.println(duplication[i]);
            }
        }
    }

    public boolean duplicate(int[] nums, int length, int[] duplication) {
        if (nums == null || length <= 0) {
            return false;
        }

        for (int i = 0; i < length; i++) {
            while (nums[i] != i && nums[i] != nums[nums[i]]) {
                swap(nums, i, nums[i]);
            }
            if (nums[i] != i && nums[i] == nums[nums[i]]) {
                duplication[0] = nums[i];
                return true;
            }
        }

        return false;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
