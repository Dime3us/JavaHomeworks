package Homework14;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        Student s = new Student("Ivan", 32, "Physic");
        Student s1 = new Student("Dima", 20, "Mathe");
        Student s2 = new Student("Max", 23, "Biologic");
        Student s3 = new Student("Nik", 37, "Astronomy");
        Student s4 = new Student("Lena", 24, "Politic");

//        List<Student> list = new ArrayList<>(Arrays.asList(s, s1, s2));
//        List<Student> list1 = new ArrayList<>(Arrays.asList(s, s1, s2, s3, s4));
//        List<Student> list2 = new ArrayList<>(Arrays.asList(s,s1));


        Professor p = new Professor("Doctor Ivanov", 2500, new ArrayList<>(Arrays.asList(s, s1, s2)));
        Professor p1 = new Professor("Sedov", 2000, new ArrayList<>(Arrays.asList(s, s1, s2, s3, s4)));
        Professor p2 = new Professor("Smirnov", 3000, new ArrayList<>(Arrays.asList(s,s1)));

        List<Professor> professorList = new ArrayList<>(Arrays.asList(p, p1, p2));

        Collections.sort(professorList);
        System.out.println(professorList);
    }


}
