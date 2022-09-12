package Homework11;

import java.util.ArrayDeque;
import java.util.Stack;


public class BracketsCheck {
    public static void main(String[] args) {
        String string = "";
        System.out.println(bracketsCheck(string));
    }


    public static boolean bracketsCheck(String string) {
        char[] array = string.toCharArray();
        Stack<Character> stack = new Stack<>();
        if (array.length % 2 != 0)
            return false;
        for (int i = 0; i < array.length; i++) {

            if (array[i] == '{' || array[i] == '(' || array[i] == '[')
                stack.push(array[i]);

            if (array[i] == '}' || array[i] == ')' || array[i] == ']') {

                if (stack.isEmpty()) {
                    return false;
                } else if (!isPair(stack.pop(), array[i])) {
                    return false;
                }
            }

        }

        if (stack.isEmpty())
            return true;

        else
            return false;
    }


    static boolean isPair(char character1, char character2) {
        if (character1 == '(' && character2 == ')')
            return true;

        else if (character1 == '{' && character2 == '}')
            return true;

        else if (character1 == '[' && character2 == ']')
            return true;

        else
            return false;
    }

}
