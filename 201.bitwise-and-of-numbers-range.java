/*
 * @lc app=leetcode id=201 lang=java
 *
 * [201] Bitwise AND of Numbers Range
 */
class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        if (m == 0) {
            return 0;
        }
        int moveFactor = 1;
        while (m != n) {
            m = m >> 1;
            n = n >> 1;
            moveFactor <<= 1;
        }
        return m * moveFactor;
        
    }
}

