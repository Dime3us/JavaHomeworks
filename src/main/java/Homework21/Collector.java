package Homework21;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;


public class Collector {
    public static void main(String[] args) {
        List<Integer> list = List.of(2, 4, 6, 8, 10, 12, 14);
        System.out.println("Average value of List elements = " + averageNumber(list));

    }

    public static Double averageNumber(List<Integer> list) {

       return list.stream().collect(new java.util.stream.Collector<Integer, List<Integer>, Double>() {
            @Override
            public Supplier<List<Integer>> supplier() {
                return ArrayList::new;
            }

            @Override
            public BiConsumer<List<Integer>, Integer> accumulator() {
                return List::add;
            }

            @Override
            public BinaryOperator<List<Integer>> combiner() {

                return (integers, integers2) -> {
                    integers.addAll(integers2);

                    return integers;
                };
            }

            @Override
            public Function<List<Integer>, Double> finisher() {
                return integers -> {
                    int sum = integers.stream().reduce(0, Integer::sum);

                    System.out.println("Sum of all elements = " + sum);
                    return (double)(sum / integers.size());
                };
            }

            @Override
            public Set<Characteristics> characteristics() {
                return Set.of(Characteristics.UNORDERED);
            }
        });


//    Напишите коллектор который из потока целых вычисляет Double среднее значение
    }
}
