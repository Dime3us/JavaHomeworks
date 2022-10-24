package Homework6;


import java.util.*;
import java.util.stream.Collectors;

public class Tester {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>() {{
            add(3);
            add(4);
            add(4);
            add(9);
        }};
        List<Integer> list2 = new ArrayList<>() {{
            add(3);
            add(4);
            add(0);
            add(9);
        }};
        List<String> list3 = new ArrayList<>() {{
            add("I");
            add("Sa");
            add("Sos");
            add("S");

        }};
        String[] array = {"Array", "List", "System", "System", "New", "Array", "New", "List", "Apple"};
        System.out.println(list1.equals(list2));
        System.out.println(listComparison(list1, list2));
        System.out.println(listCompar(list1, list2));
        System.out.println(longestOrShortest(list3));

        System.out.println(Arrays.toString(duplicateRemoving(array)));

    }

    public static boolean listComparison(List a, List b) {
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) != b.get(i)) {
                return false;
            }
        }
        return true;
    }


    public static List<String> listCompar(List a, List b) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) == b.get(i)) {
                result.add(i, "Yes");
            } else result.add(i, "No");
        }
        return result;
    }

    public static String longestOrShortest(List<String> list) {
        int longestIndex = 0;
        int shortestIndex = 0;

        if (list.size() == 0) {
            return "This list is empty";
        } else if (list.size() == 1) {
            return list.get(0).toString();
        } else {

            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).length() < list.get(shortestIndex).length()) {
                    shortestIndex = i;
                }
                if (list.get(i).length() > list.get(longestIndex).length()) {
                    longestIndex = i;
                }
            }
            String sL = list.get(longestIndex);
            String sS = list.get(shortestIndex);
            return shortestIndex < longestIndex ? sS : sL;
        }
    }

    public static String[] duplicateRemoving(String[] array) {

        List<String> list = Arrays.asList(array);
        List<String> list1 = list.stream().distinct().collect(Collectors.toList());
        String[] y = list1.toArray(new String[0]);

        return y;
    }

}
//    Напишите функцию, которая последовательно сравнивает между собой элементы из двух передаваемых в нее списков одинаковой длины.
//    Если все элементы в списках попарно одинаковы, возвращает true.
//    Пример: {1,2,3}, {4,5,6} -> false; {1,2}, {1,2} -> true; {1,2}, {2,1} -> false

//        Напишите функцию, которая последовательно сравнивает элементы двух передаваемых в нее списков одинаковой длины и возвращает
//        список строк. Пример: {1,2,3}, {1,4,3}->{"Yes", "No", "Yes"}

//        * Напишите функцию которая получает на вход список строк и возвращает либо самую короткую либо саму длинную,
//        в зависимости от того, какая встретилась раньше.

//        * Напишите функцию, которая удаляет дубликаты из передаваемого в нее массива строк.

//        * Реализовать вызов Free Weather API - документация https://open-meteo.com/en/docs ,
//        пример вызова - https://api.open-meteo.com/v1/forecast?latitude=52.52&longitude=13.41&hourly=temperature_2m
