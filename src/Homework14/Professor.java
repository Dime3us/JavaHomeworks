package Homework14;

import java.util.Arrays;
import java.util.List;

public class Professor implements Comparable<Professor> {
    String name;
    int salary;
    List<Student> StudentsList;

    public Professor(String name, int salary, List<Student> studentsList) {
        this.name = name;
        this.salary = salary;
        StudentsList = studentsList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public List<Student> getStudentsList() {
        return StudentsList;
    }

    public void setStudentsList(List<Student> studentsList) {
        StudentsList = studentsList;
    }

    @Override
    public int compareTo(Professor o) {
        return Integer.compare(StudentsList.size(), o.getStudentsList().size());  // почему нельзя вызвать reversed
    }

    @Override
    public String toString() {                                    //toString не печатает студентов
        return
                name + '\'' +
                        salary +
                        Arrays.toString(StudentsList.toArray()) +
                        '}';
    }
}
