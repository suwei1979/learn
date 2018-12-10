/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.java.java8.lambda;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Random;

/**
 *
 */
public class LoopBenchmarkMain {
    final int size = 100000;
    List<Integer> integers = null;

    public static void main(String[] args) {
        LoopBenchmarkMain benchmark = new LoopBenchmarkMain();

    }

    public void populate(List<Integer> list) {
        Random rand = new Random();

        for (int i = 0; i < size; i++) {
            list.add(Integer.valueOf(rand.nextInt(size)));
        }
    }

    public int iteratorMaxInteger() {
        int max = Integer.MIN_VALUE;
        for (Iterator<Integer> it = integers.iterator(); it.hasNext(); ) {
            max = Integer.max(max, it.next());
        }
        return max;
    }

    public int forEachLoopMaxInteger() {
        int max = Integer.MIN_VALUE;
        for (Integer n : integers) {
            max = Integer.max(max, n);
        }
        return max;
    }

    public int forMaxInteger() {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            max = Integer.max(max, integers.get(i));
        }

        return max;
    }

    public int paralledStreamMaxInteger() {
        Optional<Integer> max = integers.parallelStream().reduce(Integer::max);
        return max.get();
    }

    public int lambdaMaxInteger() {
        return integers.stream().reduce(Integer.MIN_VALUE, (a, b) -> Integer.max(a, b));
    }

    public int forEachLambdaMaxInteger() {
        final Wrapper wrapper = new Wrapper();
        wrapper.inner = Integer.MIN_VALUE;
        for (Integer i : integers) {
            helper(i, wrapper);
        }
        return wrapper.inner.intValue();
    }

    public int streamMaxInteger() {
        Optional<Integer> max = integers.stream().reduce(Integer::max);
        return max.get();
    }

    private int helper(int i, Wrapper wrapper) {
        wrapper.inner = Math.max(i, wrapper.inner);
        return wrapper.inner;
    }

    public static class Wrapper {
        public Integer inner;
    }
}
