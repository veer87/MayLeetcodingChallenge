//https://leetcode.com/problems/check-if-it-is-a-straight-line/
class Solution {
    public boolean checkStraightLine(int[][] arr) {
        int x = arr[1][1] - arr[0][1];
        int y = arr[1][0] - arr[0][0];
        if (x == 0) {
            for (int i = 2; i < arr.length; i++) {
                if ((arr[i][1] - arr[0][1]) != 0) return false;
            }
        } else {
            double tangent = ((double) y / x);
            for (int i = 2; i < arr.length; i++) {
                int tempX = (arr[i][1] - arr[0][1]);
                int tempY = (arr[i][0] - arr[0][0]);
                if (tangent != ((double) tempY / tempX)) return false;
            }
        }
    return true;
    }
}
    