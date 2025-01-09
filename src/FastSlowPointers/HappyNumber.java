package FastSlowPointers;

/**
 * Write an algorithm to determine if a number n is a happy number.
 * we use the following process to check if a given number is a happy number:
 *      - Starting with the given number n, replace the number with the sum of the squares of its digits.
 *      - Repeat the process until:
 *          + The number equals 1, which will depict that the given number n is a happy number.
 *          + The number enters a cycle, which will depict that the given number n is not a happy number
 *       Return TRUE is n is a happy number, and FALSE if not.
 *
 *  Constraints: 1 <= n <= 2^31 -1
 *
 *  Time Complexity: Consider two cases:
 *                  1. number with 3 digits:  O(n)
 *                  2. Number more than 3 digits: O(nlog(n))
 *               --> O(1 + log n) ~ O(log n)
 *
 *
 *  Space Complexity: O(1)
 *
 *
 */

public class HappyNumber {
//    public static boolean isHappyNumber(int n) {
//        if(n == 1) return true;
//        int slowPointer = n;
//        int fastPointer = SumOfSquaredDigits.sumOfSquaredDigits(n);
//
//        while(slowPointer != fastPointer) {
//            slowPointer = SumOfSquaredDigits.sumOfSquaredDigits(slowPointer);
//            fastPointer = SumOfSquaredDigits.sumOfSquaredDigits(SumOfSquaredDigits.sumOfSquaredDigits(fastPointer));
//            if(fastPointer == 1) return true;
//        }
//        return false;
//    }



        //Set up two pointers, slowPointer points to the input number,
        // and fastPointer points to the sum of squared digits of the input number.


        // Start a loop until fastPointer reaches 1 or both pointers meet, indicating a cycle.


        // Update the slowPointer by adding the squares of its digits and fastPointer by adding the squares of its digit twice

        // if fastPointer equals 1, return TRUE, indicating the number is happy.


        // Otherwise, if the loop exits without finding a happy number, return FALSE,
        // indicating the presence of a cycle and that the number is not happy.

    public static String printStringWithMarkers(String strn, int pValue) {
        String out = "";
        for (int i = 0; i < pValue; i++) {
            out += String.valueOf(strn.charAt(i));
        }
        out += "«";
        out += String.valueOf(strn.charAt(pValue)) + "»";
        for (int i = pValue + 1; i < strn.length(); i++) {
            out += String.valueOf(strn.charAt(i));
        }
        return out;
    }

    public static int sumOfSquaredDigits(int number){
        int totalSum = 0;
        while (number > 0) {
            int digit = number % 10;
            number = number / 10;
            totalSum += (Math.pow(digit, 2));
        }
        System.out.println("\t\tSum of squared digits: " + totalSum);
        return totalSum;
    }

    public static boolean isHappyNumber(int n) {
        int slowPointer = n; // The slow pointer value
//        System.out.println("\tSetting slow pointer = input number " + slowPointer);
//        System.out.println("\tSetting fast pointer = sum of squared digits of " + n);
        int fastPointer = sumOfSquaredDigits(n); // The fast pointer value
//        System.out.println("\tFast pointer:" + fastPointer);
        while (fastPointer != 1 && slowPointer != fastPointer) { // Terminating condition
//            System.out.println("\n\tRepeatedly updating slow and fast pointers\n");
            // Incrementing the slow pointer by 1 iteration
            slowPointer = sumOfSquaredDigits(slowPointer);
//            System.out.println("\tThe updated slow pointer is " + slowPointer);
            // Incrementing the fast pointer by 2 iterations
            fastPointer = sumOfSquaredDigits(sumOfSquaredDigits(fastPointer));
//            System.out.println("\tThe updated fast pointer is " + fastPointer + "\n");
        }
//        System.out.println("\tIs it a happy number?: " + (fastPointer == 1)); // If 1 is found then it returns True, otherwise False
        return fastPointer == 1;
    }
    public static void main(String args[]) {
        int a[] = {1, 5, 19, 25, 7};
        for (int i = 0; i < a.length; i++) {
            System.out.println((i + 1) + ".\tInput Number: " + a[i]);
            isHappyNumber(a[i]);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
