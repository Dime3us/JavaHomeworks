package Homework24;

import java.util.List;

public class PatternApp {
    public static void main(String[] args) {
        System.out.println(removalOfVowels("Homework домашнее задание"));
        System.out.println(isTelephoneNumber("+123456"));
        String string = "10 расходы 20 доходы 50.";
        System.out.println(toBoolean(string));

    }

    public static String removalOfVowels(String s) {
        return s.toLowerCase().replaceAll("[aeiouаеиоуыэюя]", "");
    }

    public static boolean isTelephoneNumber(String s) {
        return s.matches("\\+\\d{6}");
    }

    //Если в строке встречается число без десятичной точки ,
    // то добавьте этой цифре ".0" . Пример: "расходы 20 доходы 50.3" -> "расходы 20.0 доходы 50.3"
    public static String toBoolean(String s) {
        List<String> original = List.of(s.split(" "));

        StringBuilder builder = new StringBuilder();
        for (String string : original) {
            if (string.matches("\\d*")) {
                builder.append(string.replace(string,  string + ".0 "));
                continue;
            }
            if (string.matches("\\d*.")) {
                builder.append(string.replace(string, string + "0. "));
            }
            else
                builder.append(string).append(" ");
        }

        System.out.println(original);
        return builder.toString();
    }
}
