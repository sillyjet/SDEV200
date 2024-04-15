import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        StringBuilder text = new StringBuilder();
        try {
            File myFile = new File(args[0]);
            Scanner sc = new Scanner(myFile);
            while (sc.hasNextLine()) {
                String data = sc.nextLine();
                text.append(" ").append(data);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }
        System.out.println(text);
        boolean illegal = false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == '"' || c == '\'') {
                i = EatQuotes(String.valueOf(text), i);
            } else if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                   illegal = true;
                   break;
                }
                if (stack.peek() == '(') {
                    stack.pop();
                } else {
                    illegal = true;
                }
            } else if (c == ']') {
                if (stack.isEmpty()) {
                    illegal = true;
                    break;
                }
                if (stack.peek() == '[') {
                    stack.pop();
                } else {
                    illegal = true;
                }
            } else if (c == '}') {
                if (stack.isEmpty()) {
                    illegal = true;
                    break;
                }
                if (stack.peek() == '{') {
                    stack.pop();
                } else {
                    illegal = true;
                }
            }
        }
        if (illegal) {
            System.out.println("This document does not have correct pairs of grouping symbols.");
        } else {
            System.out.println("This document has correct pairs of grouping symbols.");
        }
    }

    public static int EatQuotes(String text, int i) {
        char q = text.charAt(i++);
        while (i < text.length()) {
            char c = text.charAt(i);
            if (c == '\\') {
                i++;
            } else if (c == q) {
                return i;
            }
            i++;
        }
        return i;
    }
}
