package TwoPointers;

public class ValidPalindrome {

    /**
     *  TWO POINTER APPROACH
     *
     *  Time complexity: is O(n) where n is the number of characters in the string. However, our algorithm will only run
     *  (n/2) times, since two pointers are traversing toward each other.
     *
     *  Space complexity: is O(1), since we use constant space to store two indexes.
     *
     *
     * @param s
     * @return true/false
     */
    public static boolean isPalindrome(String s) {
        // Initialize two pointers and move them from opposite ends.
        // The first pointer starts at the beginning of the string and moves toward the middle,
        // while the second pointer starts at the end and moves toward the middle
        int left = 0;
        int right = s.length() - 1;
        // Compare the elements at each position to detect a non-matching pair. --> return false,
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            } else {
                left = left + 1;
                right = right - 1;
            }
        }
        // if character at two pointer position is match, increase the index of pointer at the left
        // and decrease the index of pointer at the right until the middle of the string
        // If both pointers reach the middle of the string without encountering a non-matching pair,
        // the string is a palindrome.--> return true
        return true;
    }

    public static void main(String[] arg) {
        String[] test = {
                "RACEACAR",
                "A",
                "ABCDEFGFEDCBA",
                "ABC",
                "ABCBA",
                "ABBA",
                "RACEACAR"
        };
        for (int k = 0; k < test.length; k++) {
            System.out.println("Test Case #" + (k + 1));
            System.out.println(new String(new char[100]).replace('\0', '-'));
            System.out.println("The input string is " + test[k] + "' and the length of the string is " + test[k].length() + ".");
            System.out.println("\nIs it a palindrome?..... " + isPalindrome(test[k]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
