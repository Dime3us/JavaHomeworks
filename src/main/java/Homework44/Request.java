package Homework44;

import com.google.gson.Gson;

import javax.net.ssl.HttpsURLConnection;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;

public class Request {
    // https://api.frankfurter.app/latest?amount=10&from=GBP&to=USD
    public static Rate getRate(double amount, String from, String to) {
        Gson gson = new Gson();
        Rate result = null;
        try {
            URL url = new URL("https://api.frankfurter.app/latest?amount=" + amount + "&from=" + from + "&to=" + to);
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            System.out.println("getRate encoding " + connection.getContentEncoding());
            System.out.println("getRate content type " + connection.getContentType());
            Reader reader = new InputStreamReader(connection.getInputStream());
            result = gson.fromJson(reader, Rate.class);
        } catch (Exception e) {
            System.err.println("Exception in getRate " + e.getMessage());
        }
        return result;
    }
}
