/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.algorithm;

import java.util.Arrays;

/**
 * Sort
 *
 * @author suwei
 * @since 2019/8/20 : 10:42 AM
 **/
public class Sort {
    public static String[] byBubble(String[] data) {
        //assert not null or empty
        String temp;
        for (int i = 0; i < data.length; i++) {
            for (int j = data.length - 1; j > i; j--) {

                if (data[j].length() < data[j - 1].length()) {
                    temp = data[j - 1];
                    data[j - 1] = data[j];
                    data[j] = temp;
                }
            }
        }
        return data;
    }

    public static String[] bySelection(String[] data) {
        for (int i = 0; i < data.length; i++) {
            int minIdx = i;
            for (int j = i + 1; j < data.length; j++) {
                if (data[j].length() < data[minIdx].length()) {
                    minIdx = j;
                }
            }
            String tmp = data[minIdx];
            data[minIdx] = data[i];
            data[i] = tmp;
        }
        return data;
    }

    public static String[] byInsertion(String[] data) {

        int sortedIdx;
        String insertion;
        for (int i = 0; i < data.length - 1; i++) {
            sortedIdx = i;
            insertion = data[sortedIdx + 1];
            for (int j = sortedIdx; j >= 0; j--) {
                if (data[j].length() > insertion.length()) {
                    data[j + 1] = data[j];
                    data[j] = insertion;
                }
            }
            //            int insertionIdx = sortedIdx;
            //            while (insertionIdx >= 0 && insertion.length() < data[insertionIdx].length()) {
            //                data[insertionIdx + 1] = data[insertionIdx];
            //                data[insertionIdx] = insertion;
            //                insertionIdx--;
            //            }
        }
        return data;
    }

    public static String[] byShell(String[] data) {
        //        int len = data.length;
        int step = data.length;
        String insertion;

        while (true) {
            //希尔增量
            step = step / 2;//子序列
            //对序列进行
            for (int i = 0; i < step; i++) {
                for (int j = i + step; j < data.length; j = j + step) {
                    insertion = data[j];
                    for (int k = j - step; k >= 0; k = k - step) {
                        if (data[k].length() > insertion.length()) {
                            data[k + step] = data[k];
                            data[k] = insertion;
                        }
                    }
                }
            }

            if (step == 1) {
                break;
            }
        }

        return data;
    }

    public static int[] byShell(int[] data) {
        int step = data.length;
        int insertion;
        int sortedIdx;
        while (true) {
            step = step / 2;
            for (int x = 0; x < step; x++) {
                for (int i = x + step; i < data.length; i = i + step) {
                    sortedIdx = i - step;
                    insertion = data[i];
                    int j;
                    for (j = sortedIdx; j >= 0 && data[j] > insertion; j = j - step) {
                        data[j + step] = data[j];
                        data[j] = insertion;
                    }
                    System.out.print("排序轮次[" + step + "-" + x + "-" + i / step + "\t]:\t");
                    for (int k = 0; k < data.length; k++) {
                        System.out.print(data[k] + " ");
                    }
                    System.out.println();
                }
            }

            if (step == 1) {
                break;
            }
        }
        return data;
    }

    public static String[] byMerge(String[] data) {
        if (data.length < 2) {
            return data;
        }
        int mid = data.length / 2;
        String[] left = Arrays.copyOfRange(data, 0, mid);
        String[] right = Arrays.copyOfRange(data, mid, data.length);

        return merge(byMerge(left), byMerge(right));
    }

    private static String[] merge(String[] left, String[] right) {
        String[] result = new String[left.length + right.length];
        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
            if (i >= left.length) {
                result[index] = right[j++];
            } else if (j >= right.length) {
                result[index] = left[i++];
            } else if (left[i].length() > right[j].length()) {
                result[index] = right[j++];
            } else {
                result[index] = left[i++];
            }
        }
        return result;
    }

    public static String[] byQuick(String[] data, int start, int end) {
        if (data.length < 1 || start < 0 || end > data.length || start > end) {
            return null;
        }
        int smallIndex = partition(data, start, end);
        return null;
    }

    private static int partition(String[] data, int left, int right) {
        int pivot = (int) (left + Math.random() * (right - left + 1));
        int smallIndex = left - 1;
        swap(data, pivot, right);
        for (int i = left; i <= right; i++) {
            if (data[i].length() <= data[right].length()) {
                smallIndex++;
                if (i > smallIndex) {
                    swap(data, i, smallIndex);
                }
            }

        }
        return smallIndex;
    }

    private static void swap(String[] data, int left, int right) {
        String temp = data[left];
        data[left] = data[right];
        data[right] = temp;
    }

    public static void main(String[] args) {
        String[] bubbleData = {"abc", "abcde", "ab", "a", "abcd"};
        System.out.println("####### byBubble sort ######");
        long start, end;
        start = System.nanoTime();
        for (int i = 0; i < bubbleData.length; i++) {
            System.out.println(byBubble(bubbleData)[i]);
        }
        end = System.nanoTime();
        System.out.println("Time: " + (end - start));

        System.out.println("####### bySelection sort ######");
        String[] selectionData = {"abc", "abcde", "ab", "a", "abcd"};
        start = System.nanoTime();
        for (int i = 0; i < selectionData.length; i++) {
            System.out.println(bySelection(selectionData)[i]);
        }
        end = System.nanoTime();
        System.out.println("Time: " + (end - start));

        System.out.println("####### byInsertion sort ######");
        String[] insertionData = {"abc", "abcde", "ab", "a", "abcd"};
        start = System.nanoTime();
        for (int i = 0; i < insertionData.length; i++) {
            System.out.println(byInsertion(insertionData)[i]);
        }
        end = System.nanoTime();
        System.out.println("Time: " + (end - start));

        //        int len = 11;
        //        int gap = len / 2;
        //        while (gap > 0) {
        //            System.out.println("gap = " + gap);
        //            gap = gap / 2;
        //        }

        System.out.println("####### byShell sort[int] ######");
        int[] a = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1};
        System.out.print("排序之前[-----\t]:\t");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        start = System.nanoTime();
        byShell(a);
        end = System.nanoTime();
        //        long estimate = end - start;
        System.out.print("排序之后[-----\t]:\t");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        //        System.out.println("Time: " + estimate);
        System.out.println("Time: " + (end - start));

        System.out.println("####### byShell sort[String] ######");
        String[] shellData = {"abc", "abcde", "ab", "a", "abcd", "abcdef", "abcdefg", "aa", "bbd", "bbd", "awef", "asdfa", "wefqwe"};
        start = System.nanoTime();
        byShell(shellData);
        end = System.nanoTime();
        for (int i = 0; i < shellData.length; i++) {
            System.out.print(shellData[i] + ' ');
        }
        System.out.println();
        System.out.println("Time: " + (end - start));

        System.out.println("####### byMerge sort[String] ######");
        String[] dataToMerge = {"abc", "abcde", "ab", "a", "abcd", "abcdef", "abcdefg", "aa", "bbd", "bbd", "awef", "asdfa", "wefqwe"};
        start = System.nanoTime();
        String[] merged = byMerge(dataToMerge);
        end = System.nanoTime();
        for (int i = 0; i < merged.length; i++) {
            System.out.print(merged[i] + ' ');
        }
        System.out.println();
        System.out.println("Time: " + (end - start));

        int n = 10;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cnt++;
            }
        }
        System.out.println("cnt = " + cnt);
    }

}
