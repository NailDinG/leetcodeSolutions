import java.util.List;
import java.util.ArrayList;

/*
 * @lc app=leetcode id=77 lang=java
 *
 * [77] Combinations
 */
class Solution {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        int[] nums = new int[n];
        for(int i = 1; i <= n; i++) {
            nums[i - 1] = i;
        }
        combine(nums, 0, k, new ArrayList<Integer>());
        return result;
    }
    private void combine(int[] nums, int i, int k, ArrayList<Integer> tmpList) {
        if (0 == k) {
            result.add(new ArrayList<>(tmpList));
            return;
        }
        for (int m = i; m <= nums.length - k; m ++) {
            if (tmpList.size() == 0 || nums[m] > tmpList.get(tmpList.size() - 1)) {
                tmpList.add(nums[m]);
                combine(nums, i + 1, k - 1, tmpList);
                tmpList.remove(tmpList.size() - 1);
            }
        }
    }
}

