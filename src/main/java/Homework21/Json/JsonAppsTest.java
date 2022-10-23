package Homework21.Json;
import com.google.gson.Gson;
import java.io.*;

public class JsonAppsTest {

    public static void main(String[] args) throws IOException {
        Students student = new Students("Ivanov", 25, "Sinizina 32, Moskau", "man");
        System.out.println("hashCode = " + student.hashCode()+ "; " + "Age = " +student.getAge()  + "; " + "Address = " + student.getAddress());

        serializer(student);
        deserializer();
        System.out.println(Students.getCount());
           }
    public static void serializer(Students s) throws IOException {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter("src/main/java/Homework21/Json/test.txt")) {
            writer.write(gson.toJson(s));
        }
    }
    public static void deserializer() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/main/java/Homework21/Json/test.txt"));
        Students st = new Gson().fromJson(br, Students.class);
        System.out.println("hashCode = " + st.hashCode()+ "; " + "Age = " +st.getAge()  + "; " + "Address = " + st.getAddress());
    }
}
