package com.lance.mybatisplus.base.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author lance
 */

public class StreamTest {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        stream.filter(x -> x % 2 != 0).limit(3).forEach(y -> System.out.println("num: " + y));

        String[] array = {"a", "b", "c", "d", "e"};
        List<String> upperArrs = Stream.of(array).map(String::toUpperCase).collect(Collectors.toList());

        upperArrs.forEach(System.out::println);
        Supplier<Stream<String>> streamSupplier = () -> Stream.of(array);
        //get new stream
        streamSupplier.get().forEach(System.out::println);

        //get another new stream

        long count = streamSupplier.get().filter("b"::equals).count();
        System.out.println(count);

        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
// 获取对应的平方数
        List<Integer> squaresList = numbers.stream().map(i -> i * i).distinct().filter(x -> x > 9).sorted().collect(Collectors.toList());
        squaresList.forEach(System.out::println);
    }
}
