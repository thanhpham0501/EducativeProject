package TwoPointers;

import java.util.Arrays;
import java.util.List;

/**
 * Given a sentence, reverse the order of its words without affecting the order of letters within the given word.
 *
 * Constraints:
 *  - The sentence contains English uppercase and lowercase letters, digits, spaces
 *  - 1 <= sentence.length  <= 10^4
 *  - The order of the letters within a word is not to be reversed.
 *
 *  Note: The input string may contain leading or trailing spaces or multiple spaces between words. The returned string,
 *        however, should only have a single space separating each word. Do not include any extra spaces.
 *
 *  Time Complexity: O(n) - it takes O(n) time to remove the leading and trailing whitespace and replace multiple spaces
 *                   with a single space in the sentence, where n is the length of the sentence.
 *                   Additionally, the array is traversed twice in O(n+n) = O(n) time
 *
 *  Space Complexity: O(n) - since at the start of the algorithm, we copy it into a list of characters to overcome
 *                    the issue of strings being immutable in Java
 *
 */
public class ReverseWordsInAString {
    // A function that reverses characters from startRev to endRev in place
    private static void strRev(char[] str, int startRev, int endRev) {
        while (startRev < endRev) {
            char temp = str[startRev];
            str[startRev] = str[endRev];
            str[endRev] = temp;
            startRev++;
            endRev--;
        }
    }

    public static String reverseWords(String sentence) {
        // Remove extra spaces and strip leading/trailing spaces
        sentence = sentence.replaceAll("\\s+", " ").trim();
        // Convert the sentence to a character array
        // for in-place modification as strings are immutable in Java
        char[] charArray = sentence.toCharArray();
        int strLen = charArray.length -1;

        // Reverse thw whole sentence first
        strRev(charArray, 0, strLen);

        // Iterate through the sentence to find and reverse each word
        for (int start = 0, end = 0; end <= strLen; ++end) {
            if (end == strLen || charArray[end] == ' ') {
                // Include end character for the last word
                int endIdx = (end == strLen) ? end : end - 1;
                // Reverse the current word
                strRev(charArray, start, endIdx);
                // Move the "start" pointer to the start of the next word
                start = end + 1;
            }
        }
     return new String(charArray);
    }

    // Driver code
    public static void main(String[] args) {
        List<String> stringsToReverse = Arrays.asList(
                "Hello World",
                "a   string   with   multiple   spaces",
                "Case Sensitive Test 1234",
                "a 1 b 2 c 3 d 4 e 5",
                "     trailing spaces",
                "case test interesting an is this",
                "Thanh is Kate"
        );

        for (int i = 0; i < stringsToReverse.size(); i++) {
            System.out.println((i + 1) + ".\tOriginal string: '" + stringsToReverse.get(i) + "'");
            System.out.println("\tReversed string: '" + reverseWords(stringsToReverse.get(i)) + "'");
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

}
