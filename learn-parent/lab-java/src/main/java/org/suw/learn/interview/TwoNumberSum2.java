/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.interview;

import org.suw.learn.linklist.ListNode;

/**
 * TwoNumberSum2
 *
 * @author suwei
 * @since 2019/8/19 : 10:06 AM
 **/
public class TwoNumberSum2 {
    public static ListNode addTwoNumber(ListNode l1, ListNode l2) {
        return addTwoNumber(l1, l2, 0);
    }

    public static ListNode addTwoNumber(ListNode l1, ListNode l2, int carrier) {
        int nodeValue1 = 0;
        int nodeValue2 = 0;
        if (l1 != null) {
            nodeValue1 = l1.getNodeValue();
        }
        if (l2 != null) {
            nodeValue2 = l2.getNodeValue();
        }
        int nodeValue = (nodeValue1 + nodeValue2 + carrier) % 10;
        int newCarrier = (nodeValue1 + nodeValue2 + carrier) / 10;
        ListNode result;
        if (nodeValue == 0 && newCarrier == 0) {
            result = null;
        } else {
            result = new ListNode(nodeValue);
            //            ListNode nextL1 = null;
            //            ListNode nextL2 = null;
            //            if (l1 != null) {
            //                nextL1 = l1.getNext();
            //            }
            //            if (l2 != null) {
            //                nextL2 = l2.getNext();
            //            }
            result.setNext(addTwoNumber(l1 == null ? null : l1.getNext(), l2 == null ? null : l2.getNext(), newCarrier));
        }
        return result;

    }

    public static void main(String... args) {

        int[] l1array = {2, 4, 3, 7};
        int[] l2array = {5, 6, 4, 3, 9};

        ListNode l1 = getListNode(l1array);
        ListNode l2 = getListNode(l2array);

        ListNode result = addTwoNumber(l1, l2);

        while (result != null) {
            System.out.print(result.getNodeValue());
            System.out.print(result.getNext() != null ? "," : "");
            result = result.getNext();
        }

    }

    private static ListNode getListNode(int[] data) {
        if (data == null || data.length == 0) {
            return null;
        }
        ListNode root = new ListNode(data[0]);
        if (data.length > 1) {
            int[] subArray = getSubArray(data, 1);
            root.setNext(getListNode(subArray));
        }
        return root;
    }

    private static int[] getSubArray(int[] l1array, int start) {
        int[] subArray = new int[l1array.length - start];
        for (int i = start; i < l1array.length; i++) {
            subArray[i - 1] = l1array[i];
        }
        return subArray;
    }

}

