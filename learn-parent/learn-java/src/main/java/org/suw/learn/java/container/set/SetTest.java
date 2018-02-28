package org.suw.learn.java.container.set;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SetTest {
    public static void test01() {
        Set<Student> set = new TreeSet<>();
        set.add(new Student("Hao Luo", 33));
        set.add(new Student("XJ WANG", 32));
        set.add(new Student("Bruce LEE", 60));
        set.add(new Student("Bob YANG", 22));

        for(Student student : set) {
            System.out.println(student);
        }

    }

    public static void test02() {
        List<Student> list = new ArrayList<>();
        list.add(new Student("Hao Luo", 33));
        list.add(new Student("XJ WANG", 32));
        list.add(new Student("Bruce LEE", 60));
        list.add(new Student("Bob YANG", 22));

        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        for(Student student : list) {
            System.out.println(student);
        }

    }

    public static void main(String[] args) {
        test01();
        System.out.println();
        System.out.printf("");
        test02();
    }
}

class Student implements Comparable<Student> {

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;

    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        return this.age - o.age;
    }
}