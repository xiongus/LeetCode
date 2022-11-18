public class Solution_409 {


    public static void main(String[] args) {
        System.out.println(new Solution_409().longestPalindrome("ccca"));
    }

    public int longestPalindrome(String s) {
        if (s.length() == 1) return 1;
        int[] counts = new int[256];
        int odds = 0;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            counts[cur] += 1;
            // 奇数
            odds += (counts[cur] & 1) == 1 ? 1 : -1;
        }
        return s.length() - odds + (odds > 0 ? 1 : 0);
    }

    public int longestPalindrome1(String s) {
        if (s.length() == 1) return 1;
        int[] lowers = new int[26];
        int[] uppers = new int[26];
        for (char c : s.toCharArray()) {
            if (Character.isLowerCase(c)) {
                lowers[c - 'a']++;
            } else {
                uppers[c - 'A']++;
            }
        }
        int res = 0, single = 0;
        for (int lower : lowers) {
            res += lower % 2 == 0 ? lower : lower - 1;
            if (lower % 2 != 0) {
                single = 1;
            }
        }
        for (int upper : uppers) {
            res += upper % 2 == 0 ? upper : upper - 1;
            if (upper % 2 != 0) {
                single = 1;
            }
        }
        return res + single;
    }


}
