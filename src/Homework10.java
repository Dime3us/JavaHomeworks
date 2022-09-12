import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Homework10 {
    public static void main(String[] args) {

        String string = "части веб-сайтов которые вы посетили. " +
                "Узнайте, как вы можете удалить его, чтобы исправить проблемы с работой и отображением веб-сайтов";
        System.out.println(duplicateWords(string));
        wordsContains(string);
    }

    public static Collection<String> duplicateWords(String string) {
        Set<String> words = new HashSet<>();
        Set<String> stringsToPrint = new HashSet<>();
        string = string.replaceAll("\\.", "");
        string = string.replaceAll(",", "");
        for (String s : string.split("\\s+")) {
            if (!words.contains(s))
                words.add(s);
            else
                stringsToPrint.add(s);
        }
        return stringsToPrint;
    }

    public static void wordsContains(String string) {
        HashMap<String, Integer> wordToCount = new HashMap<>();
        string = string.replaceAll("\\.", "");
        string = string.replaceAll(",", "");
        String[] words = string.toLowerCase().split("\\s+");
        for (String word : words) {
            if (!wordToCount.containsKey(word)) {
                wordToCount.put(word, 0);
            }
            wordToCount.put(word, wordToCount.get(word) + 1);
        }
        for (String word : wordToCount.keySet()) {
            System.out.println(word + " : " + wordToCount.get(word));
        }

    }

}
