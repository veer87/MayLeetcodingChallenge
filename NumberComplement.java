/*
Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.
*/

class Solution {
    public int findComplement(int num) {
        if (num == 0) return 1;
        int noOfBits = (int)Math.ceil(Math.log(num) / Math.log(2));
        int ans = 0;
        for (int i = 0; i < noOfBits; i++) {
            int lShift = 1 << i;
            if ((num & lShift) == 0) ans ^= lShift;
        }
        return ans;
    }
}