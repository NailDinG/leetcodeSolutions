import java.util.ArrayList;

/*
 * @lc app=leetcode id=68 lang=java
 *
 * [68] Text Justification
 */
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < words.length) {
            int spaceCnt = 0;
            int length = 0;
            int start = i;
            // 每一行的范围
            while (i < words.length && length + words[i].length() + spaceCnt <= maxWidth) {
                length = words[i].length() + length;
                spaceCnt ++;
                i++;
            }
            if (spaceCnt > 0) spaceCnt --;
            int end = i - 1;
            int num = i - start;
            int fullfill = maxWidth - length;
            // System.out.println(fullfill);
            int bigFullfill = 0;
            int bigFullfillCnt = 0;
            int perfill = 0;
            StringBuilder sb = new StringBuilder();

            if (spaceCnt > 0) {
                if ((fullfill % spaceCnt) > 0 && end != words.length - 1) {
                    bigFullfill = fullfill / spaceCnt + 1;
                    bigFullfillCnt = fullfill % spaceCnt;
                    StringBuilder sbBigFill = new StringBuilder();
                    for (int j = 0; j < bigFullfill; j++) {
                        sbBigFill.append(" ");
                    }
                    for (int j = 0; j < bigFullfillCnt; j++) {
                        sb.append(words[start++]).append(sbBigFill);
                    }
                }
                perfill = fullfill / spaceCnt;
                int fillCnt = spaceCnt - bigFullfillCnt;
                if (end == words.length - 1) {
                    perfill = 1;
                }
                StringBuilder sbFill = new StringBuilder();
                for (int k = 0; k < perfill; k++) {
                    sbFill.append(" ");
                }
                for (int n = 0; n < fillCnt; n++) {
                    sb.append(words[start++]).append(sbFill.toString());
                }
            }
            sb.append(words[end]);
            while (sb.length() < maxWidth) {
                sb.append(" ");
            }
            res.add(sb.toString());
            i = end + 1;
        }
        return res;
    }
}
