import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Homework19 {
    public static void main(String[] args) {
        List<String> list = List.of("Окружен рабов толпой,", "c грозным деспотизма взором,",
                "афедрон ты жирный свой", "подтираешь коленкором;",
                "Я же грешную дыру", "Не балую детской модой",
                "И Хвостова жесткой одой,", "Хоть и морщуся, да тру.");
//        List<String> list2 = List.of("я и ты, ты и я, он и ты, ты и он");
        uniqueWordCount(list);
    }

    public static void uniqueWordCount(List<String> list) {
        System.out.println(list.stream().map(String::toLowerCase)
                .map(s -> s.replaceAll("\\p{Punct}", ""))
                .map(s -> s.split(" "))
                .flatMap(Stream::of)
                .collect(Collectors.toSet())
                .size());

            //distinct() method didn't work
    }
}


//  Напишите функцию которая принимает на вход список строк - например, строчки из книги.
//  Функция должна подсчитать количество уникальных слов в списке. Считаем что слова отделяются друг от друга пробелами.