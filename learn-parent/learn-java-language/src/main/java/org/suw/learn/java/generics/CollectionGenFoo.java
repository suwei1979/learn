/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.java.generics;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionGenFoo<T extends Collection<?>> {
    private T x;

    public CollectionGenFoo(T x) {
        super();
        this.x = x;
    }

    public static void main(String... args) {
        CollectionGenFoo<ArrayList<Object>> listFoo = null;
        // 出错了,不让这么干。
        // 原来作者写的这个地方有误，需要将listFoo改为listFoo1
        // 需要将CollectionGenFoo<Collection>改为CollectionGenFoo<ArrayList>
        //         CollectionGenFoo<Collection> listFoo1 = null;
        //         listFoo1=new CollectionGenFoo<ArrayList>(new ArrayList());
        System.out.println("实例化成功!");
    }

    public T getX() {
        return x;
    }

    public void setX(T x) {
        this.x = x;
    }

}
