package Homework44;
// Чтобы не плодить множество классов для первого задания
// комментируем в нашем коде все execute, так как повторно нельзя выполнить
// и создаем продавца
// stmt.execute("insert into salespeople values (1005, 'Berk', 'Oslo', 14);");
// затем удаляем продавца
// stmt.executeUpdate("delete from salespeople where sname = 'Berk' ");


import java.sql.*;
import java.util.Scanner;

public class FirstTaskAndFrankfurterApp {
    private static double amount;
    private static String from;
    private static String to;
    private static Rate rate;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter amount:");
        amount = scanner.nextDouble();

        System.out.println("Please enter starting currency: ");
        from = scanner.nextLine().replace("", scanner.nextLine());

        System.out.println("Please enter final currency:");
        to = scanner.nextLine();

        rate = Request.getRate(amount, from, to);
        System.out.println(rate);
        databaseAdd();
        tableFill();
    }

    public static void databaseAdd() {

        String basePath = "jdbc:sqlite:rate.db";
        try (Connection conn = DriverManager.getConnection(basePath);
             Statement stmt = conn.createStatement()) {

            stmt.execute("create table if not exists rate (Date text not null, Amount double not null, FromCurrency text not null, ToCurrency text not null, Rate double not null)");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void tableFill() {
        String basePath = "jdbc:sqlite:rate.db";
        try (Connection conn = DriverManager.getConnection(basePath);
             Statement stmt = conn.createStatement()) {

            stmt.execute("insert or ignore into rate values ('" + rate.date + "', '" + amount + "', '" + from + "', '" + to + "', " + rate.rates.get(to) + ");");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}

