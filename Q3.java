package viva2;

import java.util.Scanner;

public class Q3 {
    // main logic
    // 1. create a string array of size 6
    // 2. get 6 values from user and store in the array
    // 3. call custom method, checkVals, to check validity of values
    // 4. display resultant array values
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String[] array = new String[6];
        
        System.out.print("Enter 6 numerical values: ");
        for (int i = 0; i < 6; i++) {
            array[i] = scanner.next();
        }
        
        boolean[] result = checkVals(array);
        
        for (int i = 0; i < 6; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();
        
    }
    
    // checkVals method
    // 1. declare function to accept a string array, array
    // 2. create a boolean array, result, of same size as input array
    // 3. loop over length of the array
    // 4.     try to:
    // 5.         convert string to decimal
    // 6.         store true for current position in result array
    // 7.     catch exception:
    // 8.         store false for current position in result array
    // 9. return result array
    static boolean[] checkVals(String[] array) {
        boolean[] result = new boolean[array.length];

        for (int i = 0; i < array.length; i++) {
            try {
                double temp = Double.parseDouble(array[i]);
                result[i] = true;
            }
            catch (NumberFormatException e) {
                result[i] = false;
            }
        }

        return result;
    }
}
