import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=39 lang=java
 *
 * [39] Combination Sum
 */
class Solution {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        Arrays.sort(candidates);
        combinationSum(candidates, target, 0, new ArrayList<Integer>());
        return res;
    }

    private void combinationSum(int[] candidates, int target, int curr, List<Integer> tmpRes) {
        if (target == 0) {
            res.add(new ArrayList<>(tmpRes));
            return;
        }
        for (int i = curr; i < candidates.length; i ++) {
            int newTarget = target - candidates[i];
            if (newTarget >= 0) {
                tmpRes.add(candidates[i]);
                combinationSum(candidates, newTarget, i, tmpRes);
                tmpRes.remove(tmpRes.size() - 1);
            } else {
                break;
            }
        }
    }
}

