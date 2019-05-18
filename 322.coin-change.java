import java.util.Arrays;

/*
 * @lc app=leetcode id=322 lang=java
 *
 * [322] Coin Change
 * dp(account) = min(dp(amount - coin0) + 1, ... , dp(amount - coinN) + 1);
 */
class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        Integer[] mem = new Integer[amount + 1];
        //Arrays.sort(coins);
        int res = dp(coins, mem, amount);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private int dp(int[] coins, Integer[] mem, int amount) {
        if (amount < 0) {
            return 0;
        }
        if (amount == 0) {
            return mem[0];
        }
        if (mem[amount] != null) {
            return mem[amount];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i ++)  {
            if (coins[i] == amount) {
                mem[amount] = 1;
                return 1;
            }
            if (coins[i] > amount) {
                continue;
            }
            int res = dp(coins, mem, amount - coins[i]) + 1;
            if (res < min && res >= 0) {
                min = res;
            }
        }
        mem[amount] = min;
        return min;
    }
}

