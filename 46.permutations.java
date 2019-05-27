import java.util.ArrayList;

/*
 * @lc app=leetcode id=46 lang=java
 *
 * [46] Permutations
 */
class Solution {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return res;
        }
        permute(nums, 0, new ArrayList<Integer>());
        return res;
    }

    private void permute(int[] nums, int pos, ArrayList<Integer> tmpList) {
        if (pos == nums.length || tmpList.size() == nums.length) {
            res.add(new ArrayList<Integer>(tmpList));
            return;
        }
        for (int i = 0; i < nums.length; i ++) {
            if (!tmpList.contains(nums[i])) {
                tmpList.add(nums[i]);
                permute(nums, pos + 1, tmpList);
                tmpList.remove(tmpList.size() - 1);
            }
        }
    }
}

