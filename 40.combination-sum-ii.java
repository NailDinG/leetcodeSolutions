import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/*
 * @lc app=leetcode id=40 lang=java
 *
 * [40] Combination Sum II
 */
class Solution {

    List<List<Integer>> res = new ArrayList<>();
    HashSet<String> hashSet = new HashSet<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0 || target == 0) {
            return res;
        }
        Arrays.sort(candidates);
        combinationSum2(candidates, target, 0, new ArrayList<Integer>());
        return res;
    }

    private void combinationSum2(int[] candidates, int target, int curr, List<Integer> tmpList) {
        if (target == 0) {
            ArrayList<Integer> tmp = new ArrayList<>(tmpList);
            String s = tmpList.toString();
            if (hashSet.contains(s)) {
                return;
            }
            hashSet.add(s);
            res.add(tmp);
            return;
        }
        for (int k = curr; k < candidates.length; k ++) {
            int newTarget = target - candidates[k];
            if (newTarget >= 0) {
                tmpList.add(candidates[k]);
                combinationSum2(candidates, newTarget, k + 1, tmpList);
                tmpList.remove(tmpList.size() - 1);
            } else {
                break;
            }
        }
    }
}

