import java.util.HashMap;

/*
 * @lc app=leetcode id=149 lang=java
 *
 * [149] Max Points on a Line
 */
class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2) {
            return n;
        }

        int res = 0;
        for (int i = 0; i < n - 1; i ++) {
            HashMap<String, Integer> mem = new HashMap<>();
            int overLap = 0;
            int curMax = 0;
            for (int j = i + 1; j < n ; j ++) {
                int x = points[i][0] - points[j][0];
                int y = points[i][1] - points[j][1];

                if (x == 0 && y == 0) {
                    overLap ++;
                    continue;
                }

                int gcd = calGcd(x, y);
                x /= gcd;
                y /= gcd;
                String scope = x + "_" + y;
                int count = mem.getOrDefault(scope, 0);
                count ++;
                mem.put(scope, count);
                curMax = Math.max(curMax, count);
            }
            res = Math.max(curMax + overLap + 1, res);
        }
        return res;
        
    }

    // 求最大公约数
    private int calGcd(int x, int y) {
        if (y == 0) {
            return x;
        } else {
            return calGcd(y, x % y);
        }
    }
}

