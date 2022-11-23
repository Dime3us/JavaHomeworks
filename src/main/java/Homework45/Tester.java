package Homework45;

import java.sql.*;
import java.util.List;

public class Tester {
    public static void main(String[] args) throws SQLException {
        SalesDao salesDao = new SalesDao();
        CustomerDao cd = new CustomerDao();
        OrderDao od = new OrderDao();
        Order o = new Order(3012, 45977, "2022-11-23", 2009, 4001);
        od.save(o);
//        Customer ivan = new Customer(2009, "Berlin", "Johann", 150, 1001);
//        cd.save(ivan);
//        Sales max = new Sales(4001, "Max", "Warsaw", 12);
//        salesDao.save(max);
        List<Sales> allSales = salesDao.getAll();
        allSales.stream().forEach(
                sales -> System.out.println(sales.getName())
        );
        query();
    }

    public static void query() {
        String url = "jdbc:sqlite:shop.db";
        try (
                Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("select * from salespeople order by sname;");
                PreparedStatement pstmt = conn.prepareStatement("select * from salespeople where comm > ?");
        ) {
            while (rs.next()) {
                int snum = rs.getInt("snum");
                String sname = rs.getString("sname");
                String city = rs.getString("citytext");
                int comm = rs.getInt("comm");

                System.out.printf("%10d|%10s|%10s|%10d\n", snum, sname, city, comm);
            }

            pstmt.setInt(1, 14); // первый позиционный параметр
            System.out.println("-------");

            ResultSet rs1 = pstmt.executeQuery();
            while (rs1.next()) {
                int snum = rs1.getInt("snum");
                String sname = rs1.getString("sname");
                String city = rs1.getString("citytext");
                int comm = rs1.getInt("comm");
                System.out.printf("%10d|%10s|%10s|%10d\n", snum, sname, city, comm);
            }
        } catch (SQLException e) {
            System.err.println("SQLException " + e.getMessage());
        }
    }
}
