/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.linklist;

import lombok.Data;

/**
 * ListNode
 *
 * @author suwei
 * @since 2019/8/19 : 12:06 PM
 **/
@Data
public class ListNode {
    private ListNode next;
    private final int nodeValue;

    public ListNode(int nodeValue) {
        this.nodeValue = nodeValue;
    }
}
