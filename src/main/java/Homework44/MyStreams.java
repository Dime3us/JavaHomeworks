package Homework44;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MyStreams {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9}; //25
        List<String> list = List.of("Max", "Albert", "Dirk", "Anna", "Boris", "Egor", "Lol", "Лёша на полке клопа нашёл");

        int sumOfOddElements = IntStream.range(0, arr.length + 1).filter(i -> i % 2 != 0).sum();
        System.out.println(sumOfOddElements);

        List<String> listSort = list.stream().sorted(Comparator.comparing(s -> s.substring(1))).collect(Collectors.toList());
        System.out.println(listSort);

        list.stream().filter(s -> s.replaceAll("\\s+", "").
                equalsIgnoreCase(new StringBuilder(s.replaceAll("\\s+", ""))
                        .reverse().toString())).forEach(System.out::println);
    }
}
