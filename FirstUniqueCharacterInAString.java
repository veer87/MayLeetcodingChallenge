/*
https://leetcode.com/problems/first-unique-character-in-a-string/
*/
class Solution {
    public int firstUniqChar(String s) {
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) freq[ch - 'a']++;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int index = ch - 'a';
            if (freq[index] == 1) return i;
        }
        return -1;
    }
}