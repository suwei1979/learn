/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.java.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Java8NewFeatures {

    public static void main(String[] args) {
        //1. interface default implementation
        Formula formula = new Formula() {
            @Override
            public double calculate(int a) {
                return sqrt(a * 100);
            }
        };

        formula.calculate(100);     // 100.0
        formula.sqrt(16);           // 4.0

        //2. Lambda expressions
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        Collections.sort(names, (a, b) -> b.compareTo(a));

        //3. Functional Interface
        Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
        Integer converted = converter.convert("123");
        System.out.println(converted);

        Converter<String, Integer> converter1 = Integer::valueOf;
        Integer converted1 = converter1.convert("112");
        System.out.println(converted1);

        //4. Function and Constructor reference
        PersonFactory<Person> personFactory = Person::new;
        Person person = personFactory.create("Peter", "Parker");
        System.out.println(person);
        //5. Lambda operation scope
        // like inner class in old version, you must reference the variable that is marked with final

        //6. access on local variable
        int num = 1;
        Converter<Integer, String> stringConverter = (from) -> String.valueOf(from + num);
        stringConverter.convert(2);
        //	num = 3;// compile error here
        //7. 访问对象字段与静态变量
        //see Lambda4.java for details

        /**
         * 8. 访问接口的默认方法
         */
        //Formula formula8 = (a) -> sqrt(a * 100);  // can not compile
        //1) Predicate interface
        Predicate<String> predicate = (S) -> S.length() > 0;
        predicate.test("foo"); // true
        predicate.negate().test("foo"); // false

        Predicate<Boolean> notNull = Objects::nonNull;
        Predicate<Boolean> isNull = Objects::isNull;
        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNotEmpty = isEmpty.negate();

        //2) Function interface
        Function<String, Integer> toInteger = Integer::valueOf;
        Function<String, String> backToString = toInteger.andThen(String::valueOf);
        backToString.apply("123"); // 123

        //3) Supplier
        Supplier<Person> personSupplier = Person::new;
        personSupplier.get();

        //4) Consumer
        Consumer<Person> greeter = (p) -> System.out.println("Hello, " + p.getFirstName());
        greeter.accept(new Person("Luke", "Skywalker"));

        //5) Comparator
        Comparator<Person> comparator = (p1, p2) -> p1.getFirstName().compareTo(p2.getFirstName());

        Person p1 = new Person("John", "Doe");
        Person p2 = new Person("Alice", "Wonderland");

        comparator.compare(p1, p2);             // > 0
        comparator.reversed().compare(p1, p2);  // < 0

        Optional<String> optional = Optional.of("bam");
    }

}
