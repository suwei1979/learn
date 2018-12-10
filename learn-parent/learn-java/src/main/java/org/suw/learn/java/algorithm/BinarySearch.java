/*
 * Copyright (C) 2018 Wei Su(suwei1979@139.com). All Rights Reserved.
 */
package org.suw.learn.java.algorithm;

import java.util.Comparator;

public class BinarySearch {
    public static <T extends Comparable<T>> int search(T[] x, T key) {
        return search(x, 0, x.length - 1, key);
    }

    private static <T extends Comparable<T>> int search(T[] x, int low, int high, T key) {
        if (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (key.compareTo(x[mid]) == 0) {
                return mid;
            } else if (key.compareTo(x[mid]) < 0) {
                return search(x, low, mid -1, key);
            } else {
                return search(x, mid + 1, high, key);
            }
        }
        return -1;
    }

    private static <T> int search(T[] x, T key, Comparator<T> comparator) {
        int low = 0;
        int high = x.length - 1;
        while (low <= high) {
            int mid = (low + high) >> 1;
            int comp = comparator.compare(x[mid], key);
            if (comp < 0) {
                low = mid + 1;
            }
            else if (comp > 0){
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }


}
