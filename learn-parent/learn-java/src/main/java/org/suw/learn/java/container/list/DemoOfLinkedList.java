/*
 * Copyright (C) 2018 Wei Su(suwei1979@139.com). All Rights Reserved.
 */
package org.suw.learn.java.container.list;

import java.util.LinkedList;

public class DemoOfLinkedList {
    private LinkedList<String> linkedList = new LinkedList<String>();

    /**
     * 将元素加入LinkedList容器
     * （即插入链表的第一个位置）
     * @param name
     */
    public void push(String name) {
        linkedList.addFirst(name);

    }

    /**
     * 取出堆栈中最上面的元素
     * （即取出链表的第一个元素）
     * @return
     */
    public String getTop() {
        return linkedList.getFirst();
    }

    /**
     * 取出并删除最上面的元素
     * @return
     */
    public String pop() {
        return linkedList.removeFirst();
    }

    /**
     * 获取元素个数
     * @return 元素个数
     */
    public int size() {
        return linkedList.size();
    }

    public boolean isEmpty() {
        return linkedList.isEmpty();
    }


    //测试
    public static void main(String[] args) {
        DemoOfLinkedList stack = new DemoOfLinkedList();
        stack.push("yulong");
        stack.push("xiaoyun");
        stack.push("羽龙共舞");

        System.out.println("The first element is: ");
        System.out.println(stack.getTop());
        System.out.println();

        System.out.println("All elements: ");
        while (!stack.isEmpty()) {
            System.out.println("\t" + stack.pop());

        }
    }
}
