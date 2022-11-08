package Homework27;

import jakarta.xml.bind.annotation.XmlAttribute;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Emp")
public class Emp {
    private String name;
    private int age;
    private String position;

    public Emp() {
    }


    @XmlAttribute
    public String getName() {
        return name;
    }

    @XmlAttribute
    public int getAge() {
        return age;
    }

    @XmlAttribute
    public String getPosition() {
        return position;
    }

    public Emp(String name, int age, String position) {
        this.name = name;
        this.age = age;
        this.position = position;
    }

    @Override
    public String toString() {
        return "{" +
                "n='" + name + '\'' +
                ", a=" + age +
                ", p='" + position + '\'' +
                '}';
    }


}
