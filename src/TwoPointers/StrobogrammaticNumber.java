package TwoPointers;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string num representing an integer, determine whether it is a strobogrammatic number --> return TRUE. If not,
 * return FALSE.
 *
 * note: A Strobogrammatic number appears the same when rotated 180 degrees( viewed upside down ).
 *      For ex, 69 is strobogrammatic but not 962
 *
 * Constraints: 1 <= num.length <= 50
 *              num contains only digits
 *              num has no leading zeros except when the number itself is zero
 *
 * Time Complexity : O(n) where n is the length of the input string num. This is because we iterate through the string
 *                   once, comparing each digit pair from both ends toward the center
 *
 * Space Complexity: O(1) because the solution uses a fixed-size map to store the strobogramma digit mappings, regardless
 *                   of the input size.
 */
public class StrobogrammaticNumber {

    public static boolean isStrobogrammatic (String num) {
        // use dictionary to map each digit to its valid counterpart
        Map<Character, Character> dict = new HashMap<>();
        dict.put('0', '0');
        dict.put('1', '1');
        dict.put('6','9');
        dict.put('8', '8');
        dict.put('9','6');
        // Initialize two pointers: one at the start of the string and one at the end of the string
        int left = 0;
        int right = num.length() - 1;
        // compare digits from both ends, to check if match valid rotation
        while (left <= right) {
            if (!dict.containsKey(num.charAt(left)) || dict.get(num.charAt(left)) != num.charAt(right)) {
                // return false if any pairs of digits do not match its valid rotation
                return false;
            }
            // return false if any pairs of digits do not match its valid rotation
            left++;
            right--;
        }
        // return true if all pairs of digit match the strobogrammatic rule
        return true;
    }

    // Driver code
    public static void main(String[] args) {
        String[] nums = {
                "609",
                "88",
                "962",
                "101",
                "123"
        };

        int i = 0;
        for (String num : nums) {
            System.out.println((i + 1) + ".\tnum: " + num);
            System.out.println("\n\tIs strobogrammatic: " + (isStrobogrammatic(num) ? "true" : "false"));
            System.out.println(new String(new char[100]).replace("\0", "-"));
            i++;
        }
    }
}
