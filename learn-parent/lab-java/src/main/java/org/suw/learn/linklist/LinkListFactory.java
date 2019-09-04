/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.linklist;

import org.assertj.core.util.Arrays;

/**
 * LinkListFactory
 *
 * @author suwei
 * @since 2019/8/19 : 12:08 PM
 **/
public class LinkListFactory {

    public ListNode create(Integer[] data) {
        if (Arrays.isNullOrEmpty(data))
        {
            return null;
        }
        ListNode root = createNode(null, data[0]);

        for (int i = 1; i < data.length; i++) {
            createNode(root, data[i]);
        }
        return root;
    }

    public ListNode createNode(ListNode parent, int nodeValue) {
        if (parent == null) {
            return new ListNode(nodeValue);
        }
        ListNode node = new ListNode(nodeValue);
        parent.setNext(node);
        return node;
    }

}
