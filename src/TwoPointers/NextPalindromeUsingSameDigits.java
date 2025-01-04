package TwoPointers;
import java.util.*;
/**
 * Statement: Given a string num_str representing a palindrome, the string only contains digits. Returning the next
 *            possible palindrome using the same digits. The returned palindrome would be the next largest palindrome,
 *            mean there can be more than one way to rearrange the digits to make a larger palindrome. Return an empty
 *            string if not greater palindrome can be made.
 *  Constraints: 1<= num.length <= 10^5
 *               num_str is a palindrome
 */

public class NextPalindromeUsingSameDigits {
    public static boolean findNextPermutation(List<Character> digits) {
        // Step 1: Find the first digit that is smaller than the digit after it
        int i = digits.size() - 2;
        while (i >= 0 && digits.get(i) >= digits.get(i + 1)) {
            i--;
        }
        if (i == -1) {
            return false;
        }

        // Step 2: Find the next largest digit to swap with digits[i]
        int j = digits.size() - 1;
        while (digits.get(j) <= digits.get(i)) {
            j--;
        }

        // Step 3: Swap and reverse the rest to get the smallest next permutation
        Collections.swap(digits, i, j);
        Collections.reverse(digits.subList(i + 1, digits.size()));
        return true;
    }

    public static String findNextPalindrome(String numStr) {
        int n = numStr.length();

        if (n == 1) {
            return "";
        }

        int halfLength = n / 2;
        List<Character> leftHalf = new ArrayList<>();
        for (int i = 0; i < halfLength; i++) {
            leftHalf.add(numStr.charAt(i));
        }

        // Step 1: Get the next permutation for the left half
        if (!findNextPermutation(leftHalf)) {
            return "";
        }

        /**
         *  - in Java, StringBuilder is a mutable class used to create and manipulate sequence of characters efficiently.
         *  Unlike, String, StringBuilder object can be modified without creating a new object--> used in situation where
         *  frequent modifications are needed.
         *
         *  - provide methods: append(), insert(), replace(), delete(), reverse()
         *
         *  - can be converted to a String using toString() method
         */
        // Step 2: Form the next palindrome by mirroring the left half
        StringBuilder nextPalindrome = new StringBuilder();
        for (char c : leftHalf) {
            nextPalindrome.append(c);
        }

        if (n % 2 == 0) {
            nextPalindrome.append(new StringBuilder(nextPalindrome).reverse());
        } else {
            nextPalindrome.append(numStr.charAt(halfLength));
            nextPalindrome.append(new StringBuilder(nextPalindrome.substring(0, halfLength)).reverse());
        }

        // Step 3: Ensure the result is larger than the original number
        if (nextPalindrome.toString().compareTo(numStr) > 0) {
            return nextPalindrome.toString();
        }
        return "";
    }


    public static void main(String[] args) {
        String[] testCases = {"1221", "54345", "999", "12321", "89798"};

        for (int i = 0; i < testCases.length; i++) {
            System.out.println(i + 1 + ".\t Original palindrome: '" + testCases[i] + "'");
            String nextPalindrome = findNextPalindrome(testCases[i]);
            System.out.println("\t Next greater palindrome: '" + nextPalindrome + "'");
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
