import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/*
 * @lc app=leetcode id=90 lang=java
 *
 * [90] Subsets II
 */
class Solution {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null) {
            return null;
        }
        Arrays.sort(nums);
        subsetsWithDup(nums, 0, new ArrayList<Integer>());
        return res;
    }

    private void subsetsWithDup(int[] nums, int pos, ArrayList<Integer> tmpList) {
        if (pos <= nums.length) {
            res.add(new ArrayList<>(tmpList));
        }

        int i = pos;
        while (i < nums.length) {
            tmpList.add(nums[i]);
            subsetsWithDup(nums, i + 1, tmpList);
            tmpList.remove(tmpList.size() - 1);
            i ++;
            while (i < nums.length && nums[i] == nums[i - 1]) {
                i ++;
            }
        }
    }
}

