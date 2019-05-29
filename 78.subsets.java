import java.util.ArrayList;
import java.util.Arrays;

/*
 * @lc app=leetcode id=78 lang=java
 *
 * [78] Subsets
 */
class Solution {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null) {
            return res;
        } else {
            res.add(new ArrayList<Integer>());
        }
        Arrays.sort(nums);
        for (int k = 1; k <= nums.length; k ++) {
            subsets(nums, 0, k, new ArrayList<>());
        }
        return res;
    }

    private void subsets(int[] nums, int pos, int k, ArrayList<Integer> tmpList) {
        if (tmpList.size() == k) {
            res.add(new ArrayList<>(tmpList));
            return;
        }

        for (int i = pos; i < nums.length; i ++) {
            if (tmpList.size() == 0 || tmpList.get(tmpList.size() - 1) < nums[i]) {
                tmpList.add(nums[i]);
                subsets(nums, pos + 1, k, tmpList);
                tmpList.remove(tmpList.size() - 1);
            }
        }
    }
}

