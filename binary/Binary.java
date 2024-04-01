import java.util.Scanner;

public class Binary {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a binary number:");
        String b = sc.nextLine();
        sc.close();
        try {
            System.out.println(bin2Dec(b));
        }
        catch(BinaryFormatException e) {
            System.out.println(e.getMessage());
        }
    }

    public static long bin2Dec(String b) throws BinaryFormatException {
        if (b.length() > 64) {
            throw new BinaryFormatException("String is too long, must not be over 64 digits.");
        }
        long decimal = 0;
        for (int i = 0; i < b.length(); i++) {
            char c = b.charAt(i);
            if (c == '1' || c == '0') {
                int d = Character.getNumericValue(c);
                decimal *= 2;
                decimal += d;
            } else {
                throw new BinaryFormatException("String must only consist of 1s and 0s.");
            }
        }
        return decimal;
    }
}
