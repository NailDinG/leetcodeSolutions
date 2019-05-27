import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode id=47 lang=java
 *
 * [47] Permutations II
 */
class Solution {

    public List<List<Integer>> permuteUnique(int[] nums) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        res.add(new ArrayList<Integer>());

        for (int i = 0; i < nums.length; i ++) {
            HashSet<String> cache = new HashSet<>();
            while (res.peekFirst().size() == i) {
                List<Integer> curr = res.removeFirst();
                for (int j = curr.size(); j >= 0; j --) {
                    List<Integer> tmp = new ArrayList<>(curr.subList(0, j));
                    tmp.add(nums[i]);
                    tmp.addAll(curr.subList(j, curr.size()));
                    if (!cache.contains(tmp.toString())) {
                        cache.add(tmp.toString());
                        res.add(tmp);
                    }
                }
            }
        }
        return res;
    }

    /**
     * my solution is below. Of course, It is stupid.
     */
    /*
    List<List<Integer>> res = new ArrayList<>();
    HashSet<String> mem = new HashSet<>();

    public List<List<Integer>> mysolution(int[] nums) {
        if (nums == null || nums.length == 0) {
            return res;
        }
        permuteUnique(nums, 0, new ArrayList<Integer>(), new HashSet<>());
        return res;
    }

    private void permuteUnique(int[] nums, int pos, ArrayList<Integer> tmpList, HashSet<Integer> set) {
        if (pos == nums.length || tmpList.size() == nums.length) {
            if (mem.contains(tmpList.toString())) {
                return;
            }
            res.add(new ArrayList<Integer>(tmpList));
            mem.add(tmpList.toString());
            return;
        }
        for (int i = 0; i < nums.length; i ++) {
            if (!set.contains(i)) {
                tmpList.add(nums[i]);
                set.add(i);
                permuteUnique(nums, pos + 1, tmpList, set);
                tmpList.remove(tmpList.size() - 1);
                set.remove(i);
            }
        }
    }
    */
}

