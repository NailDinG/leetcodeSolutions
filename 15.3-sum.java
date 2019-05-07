import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashSet;

/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums); // 先对数组进行排序减少循环次数
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) {
            return result;
        }
        for (int i = 0; i < nums.length - 2; i++) {
            while (i > 0 && nums[i-1] == nums[i] && i < nums.length - 2) {
                i++;
            }
            int s = i + 1;
            int e = nums.length - 1;
            while(s < e && s > i && i < nums.length - 2) {
                int tmp = nums[i] + nums[s] + nums[e];
                if (tmp == 0) {
                    List<Integer> resTmpList = new ArrayList<>();
                    resTmpList.add(nums[i]);
                    resTmpList.add(nums[s]);
                    resTmpList.add(nums[e]);
                    result.add(resTmpList);
                    s++;e--;

                    while(s < nums.length && nums[s-1] == nums[s]) {
                        s++;
                    }
                    while(e > i && nums[e+1] == nums[e]) {
                        e--;
                    }
                } else if (tmp > 0) {
                    e-- ;
                } else {
                    s++;
                }
            }
        }

        return result;
    }
}

