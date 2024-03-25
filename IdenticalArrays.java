import java.util.Scanner;

public class IdenticalArrays {
    public static void main(String[] args){
        int[][] Array1 = new int[3][3];
        int[][] Array2 = new int[3][3];
        Scanner myScanner = new Scanner(System.in);
        populate(Array1, myScanner);
        populate(Array2, myScanner);
        myScanner.close();  
        if (equals(Array1, Array2)){
            System.out.println("The two arrays are identical");
        } else {
            System.out.println("The two arrays are not identical");
        }
    }
    public static boolean equals(int[][] m1, int[][] m2){
        for (int e = 0; e < 3; e++){
            for (int E = 0; E < 3; E++){
                if (m1[e][E] != m2[e][E]){
                    return false;
                }
            }
        }
        return true;
    }
    
    public static void populate(int[][] array, Scanner in){
        for (int e = 0; e < 3; e++){
            for (int E = 0; E < 3; E++){
                System.out.println("Enter a number: ");
                int element = in.nextInt();
                array[e][E] = element;
            }
        }
    }
}
