import java.util.Arrays;
import java.util.Comparator;

/*
 * @lc app=leetcode id=179 lang=java
 *
 * [179] Largest Number
 */
class Solution {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "0";
        }
        String[] numstr = new String[nums.length];
        for (int i = 0; i < nums.length; i ++) {
            numstr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(numstr, (str1, str2) -> {
            String a = str1 + str2;
            String b = str2 + str1;
            return a.compareTo(b);
        });
        boolean zeroFlag = true;
        StringBuilder res = new StringBuilder();
        for (int i = nums.length - 1; i >= 0; i --) {
            if (numstr[i].equals("0") && zeroFlag) {
                continue;
            } else {
                zeroFlag = false;
                res.append(numstr[i]);
            }
        }
        return zeroFlag ? "0" : res.toString();
    }
}

