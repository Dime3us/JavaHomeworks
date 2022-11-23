package Homework45;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDao {
    private static final String insert = "insert into orders values (?, ?, ?, ?, ?);";
    private final PreparedStatement insertStatement;
    private final Statement selectStatement;

    private static final String URL = "jdbc:sqlite:shop.db";
    public OrderDao() throws SQLException {
        Connection conn = DriverManager.getConnection(URL);
        insertStatement = conn.prepareStatement(insert);
        selectStatement = conn.createStatement();

    }

    public Order save(Order order) throws SQLException {
        insertStatement.setInt(1, order.getId());
        insertStatement.setInt(2, order.getAmount());
        insertStatement.setString(3, order.getDate());
        insertStatement.setInt(4, order.getCustomerNum());
        insertStatement.setInt(5, order.getSalesNum());
        insertStatement.execute();
        return order;
    }

    public void delete(Sales sales)
    {

    }

    public List<Order> getAll() throws SQLException {
        List<Order> result = new ArrayList<>();
        try (
                ResultSet rs = selectStatement.executeQuery("select * from orders;");
        )
        {
            while (rs.next())
            {
                result.add(
                        new Order(
                                rs.getInt("onum"),
                                rs.getInt("amt"),
                                rs.getString("odate"),
                                rs.getInt("cnum"),
                                rs.getInt("snum")
                        )
                );
            }
        }
        return result;
    }

    public List<Sales> getAllInCity(String city)
    {
        return null;
    }
}
