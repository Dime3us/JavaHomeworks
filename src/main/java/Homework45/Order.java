package Homework45;

public class Order {
    private int id;
    private int amount;
    private String date;
    private int customerNum;
    private int salesNum;

    public Order(int id, int amount, String date, int customerNum, int salesNum) {
        this.id = id;
        this.amount = amount;
        this.date = date;
        this.customerNum = customerNum;
        this.salesNum = salesNum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCustomerNum() {
        return customerNum;
    }

    public void setCustomerName(int customerName) {
        this.customerNum = customerName;
    }

    public int getSalesNum() {
        return salesNum;
    }

    public void setSalesNum(int salesNum) {
        this.salesNum = salesNum;
    }
}