package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author chenxin
 * @since 2024/5/29 星期三 16:20
 */
public class _2981 {

    public static void main(String[] args) {

    }

    public static int maximumLength(String s) {
        int ans = -1;
        int len = s.length();

        List<Integer>[] chs = new List[26];
        for (int i = 0; i < 26; i++) {
            chs[i] = new ArrayList<>();
        }
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            cnt++;
            // 统计连续的字母长度
            if (i + 1 == len || s.charAt(i) != s.charAt(i + 1)) {
                int ch = s.charAt(i) - 'a';
                chs[ch].add(cnt);
                cnt = 0;

                // 冒泡 降序排列chs中的连续字母字串长度
                for (int j = chs[ch].size() - 1; j > 0; j--) {
                    if (chs[ch].get(j) > chs[ch].get(j - 1)) {
                        Collections.swap(chs[ch], j, j - 1);
                    } else {
                        break;
                    }
                }

                // 只需要前三个,多的移除
                if (chs[ch].size() > 3) {
                    chs[ch].remove(chs[ch].size() - 1);
                }
            }
        }

        for (int i = 0; i < 26; i++) {
            // 最长的字串满足 长度大于2,则可以提供 长度为l - 2 的最长字串
            if (!chs[i].isEmpty() && chs[i].get(0) > 2) {
                ans = Math.max(ans, chs[i].get(0) - 2);
            }
            // 如果子串的个数大于1 并且最长的子串长度大于1
            // 则 如果最长的子串长度 和第二长的子串长度相同
            // 则 能够提供 maxl - 1
            // 如果不相同
            // 则能够提供 secl
            if (chs[i].size() > 1 && chs[i].get(0) > 1) {
                ans = Math.max(ans, Math.min(chs[i].get(0) - 1, chs[i].get(1)));
            }
            // 如果字串的个数大于2
            // 则能够提供 第三个子串的长度
            if (chs[i].size() > 2) {
                ans = Math.max(ans, chs[i].get(2));
            }
        }

        return ans;
    }

}
