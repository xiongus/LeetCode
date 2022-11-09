/**
 *
 * @link <a href="https://leetcode.com/problems/check-if-the-sentence-is-pangram/">1832. Check if the Sentence Is Pangram</a>
 */
class Solution_1832 {

    /**
     *
     *
     * A pangram is a sentence where every letter of the English alphabet appears at least once.
     * Given a string sentence containing only lowercase English letters, return true if sentence is a pangram, or false otherwise.
     * <p>
     * Example 1:
     * Input: sentence = "thequickbrownfoxjumpsoverthelazydog"
     * Output: true
     * </p>
     * Explanation: sentence contains at least one of every letter of the English alphabet.
     * <p>
     * Example 2:
     * Input: sentence = "leetcode"
     * Output: false
     * </p>
     * <p>
     * Constraints:
     * 1 <= sentence.length <= 1000
     * sentence consists of lowercase English letters.
     * </p>
     */

    public static void main(String[] args) {
        System.out.printf(String.valueOf((char)52));
        String str = "thequickbrownfoxjumpsoverthelazydog";
        System.out.println(str + " ==> checkIfPangram ==> " + new Solution_1832().checkIfPangram(str));
    }

    public boolean checkIfPangram(String sentence) {
        if (sentence.length() < 26) {
            return false;
        }
        for (int i = 1; i <= 26; i++) {
            if (sentence.indexOf((char)i + 96) < 0){
                return false;
            }
        }
        return true;
    }

    public boolean checkIfPangram2(String sentence) {
        // a ~ z 97 ~ 122
        int[] alphabet = new int[26];
        int count = 0;
        for (char c : sentence.toCharArray()) {
            int i = c - 97;
            alphabet[i] ++;
            if (alphabet[i] == 1) {
                count ++;
                if (count == 26) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkIfPangram1(String sentence) {
        // a ~ z 97 ~ 122
        int[] alphabet = new int[26];
        for(int i = 0; i < 26; i++) {
          alphabet[i] = 0;
        }
        for (char c : sentence.toCharArray()) {
            int i = c - 97;
            alphabet[i] ++;
        }
        for (int i : alphabet) {
            if (i == 0) {
                return false;
            }
        }
        return true;
    }
}