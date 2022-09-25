package Homework15;

public class MapTester {
    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        map.put("Moldova", "Chisinau");
        map.put("Hungary", "Budapest");
        map.put("Latvia", "Riga");
        map.put("Germany", "Berlin");
        map.put("Belarus", "Minsk");
        map.put("Russia", "Moscow");
        map.put("France", "Paris");
        map.put("Spain", "Madrid");
        map.put("Sweden", "Stockholm");
        map.put("Italy", "Rom");

        System.out.println(map.get("Moldova"));
        System.out.println(map.size());


        System.out.println(map.contains("Moldova"));
        System.out.println(map.remove("Moldova"));
        System.out.println(map.size());
        System.out.println(map.contains("Moldova"));

    }
}
