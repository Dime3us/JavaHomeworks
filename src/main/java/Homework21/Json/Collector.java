package Homework21.Json;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Collector {
    public static void main(String[] args) {
        List <Integer> list = List.of(2,4,6,8,10,12,14);
        System.out.println(averageNumber(list));
        System.out.println();
    }
public static Double averageNumber (List<Integer> list) {
        double number = 0.0;
        list.stream().collect(new java.util.stream.Collector<Integer, Double, Double>() {
            @Override
            public Supplier<Double> supplier() {
                return new Supplier<Double>() {

                    @Override
                    public Double get() {

                        return null;
                    }
                };
            }

            @Override
            public BiConsumer<Double, Integer> accumulator() {
                return null;
            }

            @Override
            public BinaryOperator<Double> combiner() {
                return null;
            }

            @Override
            public Function<Double, Double> finisher() {
                return null;
            }

            @Override
            public Set<Characteristics> characteristics() {
                return null;
            }
        });


    return number;
    }

//    Напишите коллектор который из потока целых вычисляет Double среднее значение
}
