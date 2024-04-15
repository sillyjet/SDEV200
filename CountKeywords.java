import java.util.*;
import java.io.*;

public class CountKeywords {

    public static void main(String[] args) throws Exception {
        File file = new File(args[0]);
        if (file.exists()) {
            System.out.println("The number of keywords in " + args[0] + " is " + countKeywords(file));
        } else {
            System.out.println("File " + args[0] + " does not exist");
        }
    }

    public static int countKeywords(File file) throws Exception {
        // Array of all Java keywords + true, false and null
        String[] keywordString = {"abstract", "assert", "boolean",
                "break", "byte", "case", "catch", "char", "class", "const",
                "continue", "default", "do", "double", "else", "enum",
                "extends", "for", "final", "finally", "float", "goto",
                "if", "implements", "import", "instanceof", "int",
                "interface", "long", "native", "new", "package", "private",
                "protected", "public", "return", "short", "static",
                "strictfp", "super", "switch", "synchronized", "this",
                "throw", "throws", "transient", "try", "void", "volatile",
                "while", "true", "false", "null"};

        Set<String> keywordSet = new HashSet<>(Arrays.asList(keywordString));
        int count = 0;
        boolean valid = true;
        boolean inComment = false;
        Scanner input = new Scanner(file);
        while (input.hasNext()) {
            String word = input.next();
            if (word.contains("//")) {
                input.nextLine();
            }
            if (word.contains("/*")) {
                inComment = true;
            }
            if (word.contains("*/")) {
                inComment = false;
            }
            int qCount = 0;
            if (!inComment) {
                for (int i = 0; i < word.length(); i++) {
                    char c = word.charAt(i);
                    if (c == '"') {
                        qCount += 1;
                    }
                }
                if (qCount % 2 != 0) {
                    valid = !valid;
                }
            }
            if (keywordSet.contains(word) && valid && !inComment) {
                count++;
            }
        }
        return count;
    }
}
