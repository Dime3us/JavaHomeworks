package Homework21.Json;

public class Students {
    private String name;
    private int age;
    private String address;
    private String gender;

    private static int studCount;
    public Students(String name, int age, String address, String gender) {
        this();                  // constructor chaining
        this.name = name;
        this.age = age;
        this.address = address;
        this.gender = gender;
    }

    public Students() {
        studCount++;
    }
    public static int getCount() {
        return studCount;
    }
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }


    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Students{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
