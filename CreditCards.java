import java.util.Scanner;
import java.util.ArrayList;

public class CreditCards {
    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter credit card number: ");
        long cardNum = myScanner.nextLong();
        myScanner.close();
        if (isValid(cardNum) == true){
            System.out.println(cardNum + " is valid");
        } else {
            System.out.println(cardNum + " is invalid");
        }
    }
    public static boolean isValid(long number){
        int sum = sumOfDoubleEvenPlace(number) + sumOfOddPlace(number);
        boolean validPrefix = false;
        if (prefixMatched(number, 4)){
            validPrefix = true;
        } else if (prefixMatched(number, 5)){
            validPrefix = true;
        } else if (prefixMatched(number, 37)){
            validPrefix = true;
        } else if (prefixMatched(number, 6)){
            validPrefix = true;
        }
        if (sum % 10 == 0 && getSize(number) >= 13 && getSize(number) <= 16 && validPrefix == true){
            return true;
        } else{
            return false;
        }
    }
    public static int sumOfDoubleEvenPlace(long number){
        String num = String.valueOf(number);
        ArrayList<Integer> digits = new ArrayList<>();
        int count = 0;
        boolean b = false;
        for (int e = num.length() - 1; e >= 0; e--){
            if (b == true){
                digits.add(getDigit(Character.getNumericValue(num.charAt(e))*2));
                b = !b;
            } else {
                b = !b;
            }
        }
        for (int e = 0; e < digits.size(); e++){
            count = count + digits.get(e);
        }
        return count;
    }   
    public static int getDigit(int number){
        String num = String.valueOf(number);
        int count = 0;
        if (num.length() > 1){
            for (int e = 0; e < num.length(); e++){
                count = count + Character.getNumericValue(num.charAt(e));
            }
            return count;
        } else {
            return number;
        }

    }
    public static int sumOfOddPlace(long number){
        String num = String.valueOf(number);
        ArrayList<Integer> digits = new ArrayList<>();
        int count = 0;
        boolean b = true;
        for (int e = num.length() - 1; e >= 0; e--){
            if (b == true){
                digits.add(Character.getNumericValue(num.charAt(e)));
                b = !b;
            } else {
                b = !b;
            }
        }
        for (int e = 0; e < digits.size(); e++){
            count = count + digits.get(e);
        }
        return count;
    }
    public static boolean prefixMatched(long number, int d){
        Long prefix = getPrefix(number, 2);
        String prefix1 = String.valueOf(prefix);
        String dStr = String.valueOf(d);
        return prefix1.startsWith(dStr);
    }
    public static int getSize(long d){
        String num = String.valueOf(d);
        return num.length();
    }
    public static long getPrefix(long number, int k){
        String num = String.valueOf(number);
        StringBuilder sb = new StringBuilder("");
        for (int e = 0; e <= k; e++){
            sb.append(num.charAt(e));
        }
        String prefix = sb.toString();
        return Long.parseLong(prefix);
    }
}
