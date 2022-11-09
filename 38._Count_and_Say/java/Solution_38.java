import java.util.Arrays;

/**
 * @link <a href="https://leetcode.com/problems/count-and-say/">38. Count and Say</a>
 */
public class Solution_38 {

    /**
     * The count-and-say sequence is a sequence of digit strings defined by the recursive formula:
     * <p>
     * countAndSay(1) = "1"
     * countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1), which is then converted into a different digit string.
     * To determine how you "say" a digit string, split it into the minimal number of substrings such that each substring contains exactly one unique digit. Then for each substring, say the number of digits, then say the digit. Finally, concatenate every said digit.
     * <p>
     * For example, the saying and conversion for digit string "3322251":
     * <p>
     * <p>
     * Given a positive integer n, return the nth term of the count-and-say sequence.
     */
    public static void main(String[] args) {
        int n = 4;
        System.out.println(n + " ==> countAndSay ==> " + new Solution_38().countAndSay(n));
    }

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String res = countAndSay(n - 1);
        StringBuilder sb = new StringBuilder();
        int left = 0, right = 0;
        while (right < res.length()) {
            int counter = 0;
            while (right < res.length() && res.charAt(left) == res.charAt(right)) {
                counter++;
                right++;
            }
            sb.append(counter);
            sb.append(res.charAt(left));
            left = right;
        }
        return sb.toString();
    }

    public String countAndSay1(int n) {
        if (n == 1) {
            return "1";
        }
        StringBuilder sb = new StringBuilder("1");
        for (int i = 2; i <= n; i++) {
            sb = getNextState(sb);
        }
        return sb.toString();
    }

    private StringBuilder getNextState(StringBuilder curSb) {
        StringBuilder nextSb = new StringBuilder();
        int len = curSb.length();
        int i = 0;
        while (i < len) {
            char c = curSb.charAt(i++);
            int count = 1;
            while (i < len && c == curSb.charAt(i)){
                count++;
                i++;
            }
            nextSb.append(count).append(c);
        }
        return nextSb;
    }


}
