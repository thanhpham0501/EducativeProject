package TwoPointers;
/**
 * Given a string word and an abbreviation abbr, return TRUE if the abbreviation matches the given string.
 * Otherwise, return FALSE.
 *
 *  The time complexity of the solution above is O(n) where n is the length of the abbreviation string abbr.
 *  This is because the solution processes each character of abbr exactly once.
 *
 *  The space complexity is O(1) because the algorithm uses constant extra space regardless of the input size.
 *
 */
public class ValidWordAbbreviation {

    public static boolean validWordAbbreviation(String word, String abbr) {
        int wordIndex = 0, abbrIndex = 0;

        while (abbrIndex < abbr.length()) {
            // check if the current character is a digit
            if (Character.isDigit(abbr.charAt(abbrIndex))){
                // check if there's a leading zero. if yes -> return true, no -> return false
                if (abbr.charAt(abbrIndex) == '0') {
                    return false;
                }
                int num = 0;

                while (abbrIndex < abbr.length() && Character.isDigit(abbr.charAt(abbrIndex))) {
                    num = num * 10 + (abbr.charAt(abbrIndex) - '0');
                    abbrIndex++;
                }
                // Skip the number of characters in word as found in abbreviation.
                wordIndex += num;
            } else {
                // Check if characters the match, then increment the pointers. Otherwise return False.
                if (wordIndex >= word.length() || word.charAt(wordIndex)!= abbr.charAt(abbrIndex)) {
                    return false;
                }
                wordIndex++;
                abbrIndex++;
            }
        }
        // Check if both indices have reached the end of their respective strings.
        return wordIndex == word.length() && abbrIndex == abbr.length();
    }

    public static void main(String[] args) {
        String[] words = {"a", "a", "abcdefghijklmnopqrst", "abcdefghijklmnopqrst", "word", "internationalization", "localization"};
        String[] abbreviations = {"a", "b", "a18t", "a19t", "w0rd", "i18n", "l12n"};

        for (int i = 0; i < words.length; i++) {
            System.out.println((i + 1) + ".\t word: '" + words[i] + "'");
            System.out.println("\t abbr: '" + abbreviations[i] + "'");
            System.out.println("\n\t Is '" + abbreviations[i] + "' a valid abbreviation for the word '" + words[i] + "'? " + (validWordAbbreviation(words[i], abbreviations[i])? "Yes" : "No"));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }


}
