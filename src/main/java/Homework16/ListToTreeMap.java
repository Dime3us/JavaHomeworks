package Homework16;

import java.util.*;

public class ListToTreeMap {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("Hello", "Hell", "World", "Abba"));

//        System.out.println(listToTreeMap(list));
        listToTreeMap(list);
    }

    public static TreeMap<String, TreeSet<String>> listToTreeMap(ArrayList<String> list) {
        TreeSet<String> set = new TreeSet<>();
        TreeMap<String, TreeSet<String>> map = new TreeMap<>();
        list.sort(String::compareToIgnoreCase);
        for (String s : list) {
            String c = s.substring(0, 0);
            if (map.containsKey(c)) {
                set = map.get(c);
                set.add(s);
                map.put(c, set);
                set.clear();
            } else {
                set.add(s);
                map.put(c, set);
            }


        }
        return map;
    }


}
