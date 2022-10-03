package Homework16;

import java.util.*;

public class ListToTreeMap {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("Hello", "Hell", "World","Abba"));

//        System.out.println(listToTreeMap(list));
        listToTreeMap(list);
    }

    public static /*TreeMap<String, TreeSet<String>>*/void listToTreeMap(ArrayList<String> list) {
        TreeSet<String> set = new TreeSet<>();
        TreeMap<String, TreeSet<String>> map = new TreeMap<>();
        list.sort(String::compareToIgnoreCase);
        for (String s : list) {
           char c = s.charAt(0);
            for (String s1 : list){
                if(s1.charAt(0) == c){
                    
                    TreeSet<String> s2 = new TreeSet<>();
                }
            }


//            if(!map.containsKey((s.substring(0, 0)))){
//                new TreeSet<>();
//                map.put(s.substring(0,0),this.TreeSet);
//            }


        }

    }


}
