class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] count = new int[26]; // one slot per lowercase letter

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++; // count char in s
            count[t.charAt(i) - 'a']--; // subtract count for char in t
        }

        for (int c : count) {
            if (c != 0) return false;
        }

        return true;
    }
}
