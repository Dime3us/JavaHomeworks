package Homework45;

public class Customer {
    private int id;
    private String city;
    private String name;
    private int rating;
    private int salesnum;

    public Customer(int id, String city, String name, int rating, int salesnum) {
        this.id = id;
        this.city = city;
        this.name = name;
        this.rating = rating;
        this.salesnum = salesnum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getSalesnum() {
        return salesnum;
    }

    public void setSalesnum(int salesnum) {
        this.salesnum = salesnum;
    }
}