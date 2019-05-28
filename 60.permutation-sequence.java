import java.util.ArrayList;

/*
 * @lc app=leetcode id=60 lang=java
 *
 * [60] Permutation Sequence
 */
class Solution {
    public String getPermutation(int n, int k) {
        int[] t = new int[n];
        ArrayList<Integer> nList = new ArrayList<>();
        for (int i = 1; i <= n; i ++) {
            nList.add(i);
        }
        t[0] = 1;
        for (int i = 1; i < n; i++) {
            t[i] = t[i - 1] * i;
        }
        String res = "";
        k = k - 1;
        for (int i = 1; i <= n; i ++) {
            res = res + nList.get(k / t[n - i]);
            nList.remove(k / t[n - i]);
            k = k % t[n - i];
        }
        return res;
    }
}

