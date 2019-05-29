import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=89 lang=java
 *
 * [89] Gray Code
 */
class Solution {

    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        if (n == 0) {
            res.add(0);
            return res;
        }
        res.add(0);
        res.add(1);
        for (int i = 1; i < n; i ++) {
            int base = 1 << i;
            ArrayList<Integer> tmp = new ArrayList<>();
            for (int j = res.size() - 1; j >= 0; j --) {
                tmp.add(res.get(j) + base);
            }
            res.addAll(tmp);
        }
        return res;
    }
}

