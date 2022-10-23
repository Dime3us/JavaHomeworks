package Homework21;

import java.io.File;
import java.util.Arrays;
import java.util.Objects;

public class DirectoryRider {
    public static void main(String[] args) {
        String path = "C://Users//Dime3//IdeaProjects//JavaHomeworks//target";
        dirsRider(path, "s");

        File file = new File("C://Users//");
        dirsRiderRecur(path);
    }

    public static void dirsRider(String path, String s) {
        File file = new File(path);
        Arrays.stream(Objects.requireNonNull(file.list((dir, name) -> name.contains(s)))).sorted().forEach(System.out::println);
        System.out.println("_____________________________________________");
    }

    public static void dirsRiderRecur(String s) {
        File fi = new File(s);
        for (File file : Objects.requireNonNull(fi.listFiles())) {
            if (file.isDirectory()) {
                System.out.printf("directory name is - " + file.getName());
                dirsRiderRecur(file.getPath());
            } else
                System.out.println("file name is - " + file.getName());

        }
    }
}