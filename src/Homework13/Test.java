package Homework13;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>(
                Arrays.asList(
                        new Employee(5, "Vitaliy", 31, 1600),
                        new Employee(9, "Max", 25, 1700),
                        new Employee(10, "Max", 30, 1700),
                        new Employee(7, "Dima", 40, 1900),
                        new Employee(2, "Yuriy", 40, 2200),
                        new Employee(1, "Sergey", 28, 2000)

                )
        );
        System.out.println(employees);
        Collections.sort(employees);
        System.out.println(employees);
        Collections.sort(employees, new Employee.EmployeeAgeComparator());
        System.out.println(employees);
        Collections.sort(employees, new Employee.EmployeeNameComparator());
        System.out.println(employees);
        Collections.sort(employees, new Employee.EmployeeSalaryComparator());
        System.out.println(employees);

        employees.sort(
                Comparator.comparingInt(Employee::getAge).thenComparing(Employee::getName)
        );

        System.out.println(employees);

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(1);
        list.add(4);
        list.add(5);
        list.add(1);

    }

    public static void removeNumbers(List<Integer> list) {
        Collections.sort(list);
        int startIndex = 0;
        int endIndex = 0;
        int counter = 0;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) == list.get(i - 1)) {
                counter++;
                endIndex++;
            }
        }
    }
}
