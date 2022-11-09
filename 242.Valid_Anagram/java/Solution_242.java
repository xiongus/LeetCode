public class Solution_242 {

    public static void main(String[] args) {
        String s = "rat", t = "car";
        System.out.println("s==>" + s + ", t==>" + t + ", isAnagram ==>" + new Solution_242().isAnagram(s, t));
    }

    /**
     * anagram 变位词（指变换某个词或短语的字母顺序构成的新词或短语）
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] a = new int[26], b = new int[26];
        for (char c : s.toCharArray()) a[c - 97]++;
        for (char c : t.toCharArray()) b[c - 97]++;
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
}
