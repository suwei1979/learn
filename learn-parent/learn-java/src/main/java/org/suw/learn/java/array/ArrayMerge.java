/**
 * Copyright (C) 2015 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.java.array;

/**
 * @author suwei
 *
 */
public class ArrayMerge {

    
    public static void main(String[] args) {
        int[] array1 = {5, 6, 7, 8};
        int[] array2 = {};
        
        int[] arrayMerged = new int[array1.length + array2.length];
        System.arraycopy(array1, 0, arrayMerged, 0, array1.length);
        System.arraycopy(array2, 0, arrayMerged, array1.length, array2.length);
        //
        for (int i : arrayMerged) {
            System.out.println(i);
        }
//        ArrayMerge.class.getI
        
    }
}
