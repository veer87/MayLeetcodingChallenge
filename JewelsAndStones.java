//https://leetcode.com/problems/jewels-and-stones/
class Solution {
    public int numJewelsInStones(String J, String S) {
        int count = 0;
        /* As size of S and J is less which is 50(act as constant) then we can use (n * m) complexity code. It is            faster than commented frequency count code below*/
        for (char s : S.toCharArray()) {
            for (char j : J.toCharArray()) {
                if (s == j) {
                    count++;
                    break;
                }
            }
        }
        return count;
        
        /*
        int count = 0;
        int[] freq = new int[256];
        for (char ch : S.toCharArray()) freq[ch]++;
        for (char ch : J.toCharArray()) count += freq[ch];
        return count;
        */
    }
}