import java.util.List;

/*
 * @lc app=leetcode id=93 lang=java
 *
 * [93] Restore IP Addresses
 */
class Solution {

    List<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        if (s.length() < 4 || s.length() > 12) {
            return res;
        }
        restoreIpAddresses(s, 0, 0, new String[4]);
        return res;
    }

    private void restoreIpAddresses(String s, int pos, int cur, String[] tmpIp) {
        if (pos > s.length()) {
            return;
        }
        if (pos == s.length() && cur == 4) {
            res.add(String.join(".", tmpIp));
            return;
        } else if (pos >= s.length() || cur == 4) {
            return;
        }

        for (int i = 1; i <= 3 && i + pos <= s.length(); i++) {
            String tmp = s.substring(pos, pos + i);
            if ((int) Integer.valueOf(tmp) > 255 || (tmp.length() >= 2 && tmp.charAt(0) == '0')) {
                break;
            }
            tmpIp[cur] = tmp;
            restoreIpAddresses(s, pos + i, cur + 1, tmpIp);
        }
    }
}
