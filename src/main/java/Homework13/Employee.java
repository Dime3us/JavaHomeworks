package Homework13;


import java.util.Comparator;
import java.util.List;

public class Employee implements Comparable<Employee> {

    private Integer id;
    private String name;
    private int age;
    private int salary;

    public Employee(int id, String name, int age, int salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }

    public int getSalary() {
        return salary;
    }


    @Override
    public int compareTo(Employee o) {
        return id.compareTo(o.getId());
    }

    public static class EmployeeAgeComparator implements Comparator<Employee> {
        @Override
        public int compare(Employee o1, Employee o2) {
            return Integer.compare(o1.getAge(), o2.getAge());
        }
    }

    public static class EmployeeSalaryComparator implements Comparator<Employee> {
        @Override
        public int compare(Employee o1, Employee o2) {
            return Integer.compare(o1.getSalary(), o2.getSalary());
        }
    }

    public static class EmployeeNameComparator implements Comparator<Employee> {
        @Override
        public int compare(Employee o1, Employee o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }
    public static void complexSort(List<Employee> employees, List<Comparator<Employee>> comparators){
        // TODO: 19.09.2022  
    }
}
