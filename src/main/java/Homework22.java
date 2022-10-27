import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Homework22 {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("src/main/java/test.txt"));
        String max = String.valueOf(lines.stream().map(s -> s.split(" ")).sorted(Comparator.comparing(strings -> strings.length)));
        System.out.println(max.toString());
    }
}
