package Homework45;

import java.sql.*;

public class CreateDBAndTables {
    public static void main(String[] args) {

        String url = "jdbc:sqlite:shop.db";
        try (
                Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement();
        ) {
            stmt.execute("create table if not exists salespeople (snum int primary key not null, sname text not null, city" +
                    "text not null, comm integer not null);");

            stmt.execute("create table if not exists customers (cnum int primary key not null, cname text not null, city" +
                    "text not null, rating integer not null, snum int not null);");

            stmt.execute("create table if not exists orders (onum int primary key not null, amt int not null, odate text" +
                    "not null, cnum int not null, snum int not null);");

            stmt.execute("insert into salespeople values (1001, 'Peel', 'London', 12);");
            stmt.execute("insert into salespeople values (1002, 'Serres', 'San Jose', 13);");
            stmt.execute("insert into salespeople values (1004, 'Motika', 'London', 11);");
            stmt.execute("insert into salespeople values (1007, 'Rifkin', 'Barcelona', 15);");
            stmt.execute("insert into salespeople values (1003, 'Axelrod', 'New York', 10);");

            stmt.execute("insert into customers values (2001, 'Hoffman', 'London', 100, 1001);");
            stmt.execute("insert into customers values (2002, 'Giovanni', 'Rome', 200, 1003);");
            stmt.execute("insert into customers values (2003, 'Liu', 'San Jose', 200, 1002);");
            stmt.execute("insert into customers values (2004, 'Grass', 'Berlin', 300, 1002);");
            stmt.execute("insert into customers values (2006, 'Clemens', 'London', 100, 1001);");
            stmt.execute("insert into customers values (2008, 'Cisneros', 'San Jose', 300, 1007);");
            stmt.execute("insert into customers values (2007, 'Pereira', 'Rome', 100, 1004);");

            stmt.execute("insert into orders values (3001, 1869, '1990-10-03', 2008, 1007);");
            stmt.execute("insert into orders values (3003, 76719, '1990-10-03', 2001, 1001);");
            stmt.execute("insert into orders values (3002, 190010, '1990-10-03', 2007, 1004);");
            stmt.execute("insert into orders values (3005, 516045, '1990-10-03', 2003, 1002);");
            stmt.execute("insert into orders values (3006, 109816, '1990-10-03', 2008, 1007);");
            stmt.execute("insert into orders values (3009, 171323, '1990-10-04', 2002, 1003);");
            stmt.execute("insert into orders values (3007, 7575, '1990-10-04', 2004, 1002);");
            stmt.execute("insert into orders values (3008, 472300, '1990-10-05', 2006, 1001);");
            stmt.execute("insert into orders values (3010, 130995, '1990-10-06', 2004, 1002);");
            stmt.execute("insert into orders values (3011, 989188, '1990-10-07', 2002, 1001);");

        } catch (SQLException e) {
            System.err.println("SQLException " + e.getMessage());
        }
    }
}
