//https://leetcode.com/problems/valid-perfect-square/
class Solution {
    public boolean isPerfectSquare(int num) {
        if (num == 0) return false;
        if (num == 1) return true;
        return bs(0, num, num);
    }
    
    private boolean bs(int left, int right, int key) {
        if (left >= right) return false;
        int mid = left + (right - left) / 2;
        int quo = key / mid; // find quotient of the key
        if (key % mid == 0 && quo == mid) return true;
        if (quo < mid) return bs(left, mid, key); // if the quotient less than the mid value then go left side of the mid
        else return bs(mid + 1, right, key);// if it is greater than go right side of the mid
        
    }
}
/*
testcases:-
2147395600
808201
0
1
2
3
4
5
6
7
8
9
11
12
13
14
15
16
16
1
23
4
5
3
5
100
81
16
1
23
4
5
3
5
100
81
132334532
432524364
2147483647
234632
999999
1000000
11111111
2147483000
2147483123
2147482352
*/
