package Homework45;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao {
    private static final String insert = "insert into customers values (?, ?, ?, ?, ?);";
    private final PreparedStatement insertStatement;
    private final Statement selectStatement;

    private static final String URL = "jdbc:sqlite:shop.db";

    public CustomerDao() throws SQLException {
        Connection conn = DriverManager.getConnection(URL);
        insertStatement = conn.prepareStatement(insert);
        selectStatement = conn.createStatement();

    }

    public Customer save(Customer cust) throws SQLException {
        insertStatement.setInt(1, cust.getId());
        insertStatement.setString(2, cust.getName());
        insertStatement.setString(3, cust.getCity());
        insertStatement.setInt(4, cust.getRating());
        insertStatement.setDouble(5, cust.getSalesnum());
        insertStatement.execute();
        return cust;
    }

    public List<Customer> getAll() throws SQLException {
        List<Customer> result = new ArrayList<>();
        try (
                ResultSet rs = selectStatement.executeQuery("select * from customers;");
        )
        {
            while (rs.next())
            {
                result.add(
                        new Customer(
                                rs.getInt("cnum"),
                                rs.getString("citytext"),
                                rs.getString("cname"),
                                rs.getInt("rating"),
                                rs.getInt("snum")
                        )
                );
            }
        }
        return result;
    }
}
