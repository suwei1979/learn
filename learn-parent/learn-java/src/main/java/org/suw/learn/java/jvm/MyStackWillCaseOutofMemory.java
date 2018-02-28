package org.suw.learn.java.jvm;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * 可以导致内存泄漏的Stack实现示例
 * @param <T>
 */
public class MyStackWillCaseOutofMemory<T> {
    private T[] elements;
    private int size = 0;

    private static final int INIT_CAPACITY = 16;

    public MyStackWillCaseOutofMemory() {
        elements = (T[]) new Object[INIT_CAPACITY];
    }

    public void push(T element) {
        ensureCapacity();
        elements[size++] = element;
    }

    /**
     * 从当前堆栈弹出对象
     * 注：此对象因为没有从栈顶删除对象，因而会导致对象一直存在过期引用(obsolete reference)<br />
     * 因而会导致相应对象不会被当做垃圾回收。
     * @return
     */
    public T pop() {
        if (size == 0) {
            throw new EmptyStackException();

        }
        // 此处写法会导致内存泄漏
        return elements[--size];
    }

    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2*size + 1);
        }
    }
}
