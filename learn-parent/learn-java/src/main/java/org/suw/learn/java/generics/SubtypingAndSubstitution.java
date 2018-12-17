/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.java.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubtypingAndSubstitution {

    public static void main(String... args) {
        // Example 1
        List<Number> nums = new ArrayList<Number>();
        nums.add(2);
        nums.add(3.14);
        assert nums.toString().equals("[2, 3.14]");

        // Example 2
        List<Integer> ints = Arrays.asList(1, 2);
        /**
         * 如果放开下面这行注释，则报编译时错误，原因： 作为已指定了类型为Integer的List
         * ints来说，不能再将其分配类型为List<Number>的nums， 否则将导致ints可以插入double值，
         * 1. 简单来说就是，一旦泛型被Assign了类型，不能再将具体的具有泛型的对象指派给具有其父类作为泛型的对象
         * 2. 再简单来说是，已实例化的泛型，是不支持继承的。
         * 3. 总之泛型一旦具体化，就不支持向上转型。
         */
        // List<Number> nums = ints; // compile-time error
        nums.add(3.14);
        assert ints.toString().equals("[1, 2, 3.14]"); // uh oh!

        //Example 3
        List<Number> nums1 = Arrays.<Number>asList(2.78, 3.14);
        /**
         * 下面这行毫无疑问也是错误的
         */
        //List<Integer> ints1 = nums1;  // compile-time error
        assert ints.toString().equals("[2.78, 3.14]");  // uh oh!

    }
}
