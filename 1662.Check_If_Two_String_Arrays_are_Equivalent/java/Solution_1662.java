import java.util.*;

public class Solution_1662 {

    public static void main(String[] args) {
        String[] word1 = {"abc", "d", "def"};
        String[] word2 = {"abcddef"};
        System.out.println("word1 ==>" + Arrays.toString(word1)
                + ", word2 ==>" + Arrays.toString(word2)
                + ", arrayStringsAreEqual ==>" + new Solution_1662().arrayStringsAreEqual(word1, word2));

    }

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        return String.join("", word1).equals(String.join("", word2));
    }

    public boolean arrayStringsAreEqual3(String[] word1, String[] word2) {
        return toString(word1).equals(toString(word2));
    }

    private String toString(String[] word) {
        StringBuilder sb = new StringBuilder();
        for (String s : word) {
            sb.append(s);
        }
        return sb.toString();
    }

    public boolean arrayStringsAreEqual2(String[] word1, String[] word2) {
        if (word1.length == 0 || word2.length == 0) {
            return true;
        }
        int i = 0, j = 0;
        String w1 = word1[i], w2 = word2[j];
        while (true) {
            if (w1.length() == 0 && i < word1.length - 1) {
                i++;
                w1 = word1[i];
            }
            if (w2.length() == 0 && j < word2.length - 1) {
                j++;
                w2 = word2[j];
            }
            if (w1.length() == 0 || w2.length() == 0) {
                break;
            }

        }
        return w1.length() == w2.length();
    }


    public boolean arrayStringsAreEqual1(String[] word1, String[] word2) {
        if (word1.length == 0 || word2.length == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (String s : word1) {
            char[] chars = s.toCharArray();
            for (char aChar : chars) {
                stack.push(aChar);
            }
        }
        for (int i = word2.length - 1; i >= 0; i--) {
            char[] chars = word2[i].toCharArray();
            for (int j = chars.length - 1; j >= 0; j--) {
                if (stack.empty()) {
                    return false;
                }
                char c = stack.pop();
                if (c != chars[j]) {
                    return false;
                }
            }
        }
        if (!stack.empty()) {
            return false;
        }
        return true;
    }
}
