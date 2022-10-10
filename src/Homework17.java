import org.testng.util.Strings;

public class Homework17 {
    public static void main(String[] args) {
        String string = "baaabbcccdaab";
        String string1 = "1b3a2b3c1d2a1b";
        int[] array = {0, 1, 0, 2, 0, 3, 0, 4, 0, 5};
        System.out.println(stringCoder(string));
        System.out.println(stringDecoder(string1));
        System.out.println(test(array, 20));

    }

    public static String stringCoder(String string) {
        if (string.length() == 0)
            return "Please enter your text";
        char[] array = string.toCharArray();
        StringBuilder b = new StringBuilder();


        int counter = 1;
        int i;
        for (i = 1; i < array.length; i++) {

            if (array[i - 1] == array[i]) {
                counter++;

                continue;
            }
            b.append(counter).append(array[i - 1]);
            counter = 1;
        }
        b.append(counter).append(array[i - 1]);
        return b.toString();
    }

    public static String stringDecoder(String string) {
        if (string.length() == 0)
            return "Please enter your text";
        char[] array = string.toCharArray();
        String result = "";

        int counter = 0;
        for (int i = 0; i < array.length - 1; i++) {
            counter = Character.getNumericValue(array[i]);
            result = result + Strings.repeat(Character.toString(array[i + 1]), counter);
            i++;

        }


        return result;
    }

    public static boolean test(int[] a, int b) {
        if (a.length == 0) {
            System.out.println("The array is empty");
            return false;
        }
        for (int i = 0; i < a.length - 1; i++) {

            if (b == 0 && a[i] == 0)
                return true;
            if (a[i] == 0)
                continue;
            if (b % a[i] != 0)
                continue;
            for (int j = i + 1; j < a.length; j++) {
                if (b == 0 && a[j] == 0)
                    return true;

                if (b / a[i] == a[j])
                    return true;
            }
        }
        return false;
    }
}
