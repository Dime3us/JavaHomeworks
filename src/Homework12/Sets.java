package Homework12;

import java.util.*;

public class Sets {
    public static void main(String[] args) {
        Integer[] list = {1, 2, 5, 6, 8, 2, 4};

        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        set1.add("Четыре");
        set1.add("черненьких");
        set2.add("Четыре");
        set2.add("черненьких");
        System.out.println(checkSets(set1, set2));
        System.out.println(sequenceOfNumbers(List.of(list)));
    }

    public static boolean checkSets(Set<String> s1, Set<String> s2) {


        if (s1 == s2)
            return true;
        if (s1 == null || s2 == null)
            return false;
        if (s1.size() != s2.size())
            return false;
        for (String string : s1) {
            if (!s2.contains(string))
                return false;
        }
        return true;
    }

    public static Collection<Integer> sequenceOfNumbers(List<Integer> list) {
        List<Integer> array = new ArrayList<>();
        List<Integer> arrayTemp = new ArrayList<>();

        for (int i = 1; i < list.size(); i++) {
//        for (int i : list
//        ) {


            if (arrayTemp.size() == 0 && list.get(i-1) % 2 == 0) {
                arrayTemp.add(list.get(i-1));
            }
//            if (i+1  < list.size()) {
                if (list.get(i+1) - list.get(i) == 2) {
                    arrayTemp.add(list.get(i+1));

            } else if
            (arrayTemp.size() > array.size() && arrayTemp.size() > 1) {
                array.clear();
                for (int j = 0; j < arrayTemp.size(); j++) {
                    array.add(j, arrayTemp.get(j));
                }
                if (array.size() == 1) {
                    array.clear();
                }
                arrayTemp.clear();

            } else {

                arrayTemp.clear();
            }

        }
        return array;
    }
}



   /*
    Напишите функцию для сравнения двух сетов - boolean checkSets(Set<String> s1, Set<String> s2)
     - использовать любые операции кроме Set.equals()
    */

