public class Solution_383 {


    public static void main(String[] args) {
        String ransomNote = "aa";
        String magazine = "ab";
        System.out.println(" res ==> " + new Solution_383().canConstruct(ransomNote, magazine));
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;
        int[] words = new int[26];
        for (char c : magazine.toCharArray()) {
            words[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            words[c - 'a']--;
            if (words[c - 'a'] < 0) return false;
        }
        return true;
    }


}
