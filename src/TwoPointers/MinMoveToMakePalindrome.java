package TwoPointers;
/**
 * Statement: Given a string s, return the minimum number of moves required to transform s into a palindrome
 *            in each move, you can swap any to adjacent characters in s.
 *
 * Note: The input string is guaranteed to be convertible into a palindrome.
 *
 * Constraints: - 1 <= s.length <= 2000
 *              - s consist of only lowercase English letters
 *              - s is guaranteed to be converted into a palindrome in a finite number of moves.
 *
 * Time Complexity : O(n^2) - where n is the length of the input string s
 *                  The outer loop runs from i = 0 to approximately n/2, where n is the length of the string.
 *                  So, this loop runs O(n) times. The inner loop starts with k = j and works its way backward to i
 *                  to find the matching character.
 *                  In the worst case, where no early match is found, the inner loop runs O(n) times
 *                  (as k traverses from j to i). Therefore, the overall time complexity is O(n^2)
 *
 * Space Complexity: O(n)
 */

import java.util.Arrays;
import java.util.List;

public class MinMoveToMakePalindrome {
    public static int minMovesToMakePalindrome(String s) {
        //convert string s into a new array contain spaces and special characters
        // (because Strings in java are immutable and character array is mutable
        // -> change to array do not affect the original string)
        char[] chars = s.toCharArray();

        // initialize moves with 0 to keep track of number of swap required
        int moves = 0;

        // Two-pointers approach: i starts from beginning and j starts from the end
        // Loop to find a character from the right (s[j]) that
        // matches with a character from the left (s[i])
        for (int i = 0, j = chars.length - 1; i < j; ++i) {
            int k = j;

           //Search for a character matching chars[i], starting from the end [j]
            for (;k > i; --k ){
                // If a matching character is found
               if (chars[i] == chars[k])  {
                   // Move the matching character to the correct position on the right
                  for (; k < j; ++k) {
                    // Swap characters
                      char temp = chars[k];
                      chars[k] = chars[k+1];
                      chars[k+1] = temp;
                      // Increment count of swaps
                      ++moves;
                  }
                  // Move the right pointer inwards
                   --j;
                  break;
               }
            }

            if (k == i) {
              moves += chars.length / 2 - i;
            }
        }
        return moves;
    }

    public static void main(String[] args) {
        // List of test strings to check the function
        List<String> strings = Arrays.asList("ccxx", "arcacer", "w", "ooooooo", "eggeekgbbeg");

        // Loop through each test string and calculate the moves
        for (int i = 0; i < strings.size(); ++i) {

            // Print the string and its corresponding moves
            System.out.println((i + 1) + ".\ts: " + strings.get(i));
            System.out.println("\tMoves: " + minMovesToMakePalindrome(strings.get(i)));

            // Print a line separator for better readability
            System.out.println(new String(new char[50]).replace("\0", "-"));
        }
    }
}
