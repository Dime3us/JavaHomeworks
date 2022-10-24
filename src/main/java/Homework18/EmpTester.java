package Homework18;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmpTester {
    public static void main(String[] args) {
        List<Emp> employees = List.of(new Emp("Max Petrov", 22, "programmer"),
                new Emp("Ivan Shapovalov", 33, "analyst"),
                new Emp("Semen Dezhnev", 55, "manager"),
                new Emp("Oleg Petrov", 19, "intern"),
                new Emp("Katerina Drogova", 31, "programmer"),
                new Emp("Nikolas Spivakov", 23, "analyst"),
                new Emp("Boris Moiseev", 48, "manager"),
                new Emp("Petr Sveshnikov", 37, "programmer"),
                new Emp("Alex Con", 33, "analyst"),
                new Emp("Olga Filimonova", 27, "programmer"));

        // найдите самого молодого
        employees.stream()
                .min(Comparator.comparing(Emp::getAge))
                .ifPresent(System.out::println);

        // распечатайте только имена всех работников
        employees.stream()
                .map(Emp::getName)
                .forEach(System.out::println);

        // распечатать всех с возрастом больше 41 года
        employees.stream()
                .filter(emp -> emp.getAge() > 41)
                .forEach(System.out::println);


        // распечатать всех работников отсортировав их по профессии и возрасту
        employees.stream()
                .sorted(Comparator.comparing(Emp::getAge))
                .sorted(Comparator.comparing(Emp::getPosition))
                .forEach(System.out::println);

        // заджойнить имена всех работников старше 36 лет через ", "

        String result =
                employees.stream()
                        .filter(emp -> emp.getAge() > 36)
                        .map(Emp::getName)
                        .collect(Collectors.joining(", "));
        System.out.println(result);


        //       посчитайте сумму возрастов работников
        int sum = employees.stream()
                .mapToInt(Emp::getAge).sum();
        System.out.println(sum);


        // посчитайте количество программистов

        long sum1 = employees.stream()
                .filter(emp -> emp.getPosition()
                        .equals("programmer")).count();
        System.out.println(sum1);

        // посчитайте средний возраст

        double averageAge = employees.stream()
                .map(Emp::getAge)
                .reduce(0, Integer::sum)
                .doubleValue() / employees.size();
        System.out.println(averageAge);

        // разделите на две группы - старше 40 лет и младше
        Map<Boolean, List<Emp>> oldYoung = employees.stream()
                .collect(Collectors.partitioningBy(emp -> emp.getAge() > 40));
        System.out.println(oldYoung);

//        найдите профессию самого "старого" из "молодых"
//
        oldYoung.get(false).stream().max(Comparator.comparing(Emp::getAge)).ifPresent(System.out::println);

        // сгруппируйте по профессии
        Map<String, List<Emp>> grouping = employees.stream().collect(Collectors.groupingBy(Emp::getPosition));
        System.out.println(grouping);

        // распечатать профессии и количество работников в ней
        Map<String, Long> count = employees.stream().collect(Collectors.groupingBy(Emp::getPosition, Collectors.counting()));
        System.out.println(count);

        // вернуть средний возраст мужчин и женщин - у женщин фамилия оканчивается на "a"

        employees.stream()
                .filter(emp -> emp.getName().charAt(emp.getName().length() - 1) == 'a')
                .mapToDouble(Emp::getAge).average().ifPresent(System.out::println);

        employees.stream()
                .filter(emp -> emp.getName().charAt(emp.getName().length() - 1) != 'a')
                .mapToDouble(Emp::getAge).average().ifPresent(System.out::println);

//
//
        // распечатать работников с самым часто встречающимся возрастом

 /*       Map<Integer, List<Emp>> mostCommonAge =
                employees.stream()
                        .collect(
                                Collectors.groupingBy(Emp::getAge));
        System.out.println(mostCommonAge);
        books.stream().collect(Collectors.toMap(Book::getIsbn, Book::getName));
        */

    }
}
