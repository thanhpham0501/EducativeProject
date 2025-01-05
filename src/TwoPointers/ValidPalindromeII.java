package TwoPointers;

public class ValidPalindromeII {
    public static boolean isValidPalindromeII (String string){
        int left = 0;
        int right = string.length() -1;
        while (left < right) {
            if (string.charAt(left) == string.charAt(right)) {
                left++;
                right--;
            } else {
                // Skip the element from the other side, and check for the palindrome
                return isSubStringPalindrome(string, left+1, right) || isSubStringPalindrome(string, left, right -1);
            }
        }
        return true; // if no mismatches are found
    }
    // method to check substring is a palindrome
    public static boolean isSubStringPalindrome( String string, int left, int right) {
        while (left < right){
            if (string.charAt(left) != string.charAt(right)){
                return false;
            }
            left++;
            right--;
        } return true;
    }
    public static void main(String[] args) {
        String[] input = {"madame", "dead", "abca", "tebbem", "eeccccbebaeeabebccceea"};
        for (String output : input) {
            boolean result = isValidPalindromeII(output);
            System.out.println("Input: " + output + "can become a valid palindrome by remove one character: " + result);
        }
    }
}
