package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenxin
 * @since 2024/5/20 星期一 下午4:54
 */
public class _1542 {

    public static void main(String[] args) {

        System.out.println(longestAwesome("3242415"));
    }

    public static int longestAwesome(String s) {
        int n = s.length();
        Map<Integer, Integer> prefix = new HashMap<>();
        // 初始化最开始的位置 以及下标
        prefix.put(0, -1);
        int ans = 0;
        int sequence = 0;
        for (int j = 0; j < n; ++j) {
            int digit = s.charAt(j) - '0';
            // 对每一个出现的数字进行奇偶计数,1:奇数 0:偶数
            sequence ^= (1 << digit);

            // 如果在当前下标之前已经包含这个奇偶计数
            // 加入之前的这个奇偶奇数下标为i
            // 当前的下标为 j
            // 那么说明 s[i,j] 一定是超赞字符串
            // 取最大值
            if (prefix.containsKey(sequence)) {
                ans = Math.max(ans, j - prefix.get(sequence));
            } else {
                prefix.put(sequence, j);
            }

            // 循环
            // 将当前的奇偶计数 的每一位设为相反值
            // 并查询是否已经存在和当前奇偶计数之差一位的奇偶计数
            // 如果有那么 s[i,j] 也一定是超赞字符串
            // 取最大值
            for (int k = 0; k < 10; ++k) {
                if (prefix.containsKey(sequence ^ (1 << k))) {
                    ans = Math.max(ans, j - prefix.get(sequence ^ (1 << k)));
                }
            }
        }
        return ans;
    }

    public static int longestAwesome1(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;

        int[] masks = new int[n + 1];
        int[] lastIndices = new int[1024];

        int mask = 0;

        for (int i = 0; i < n; i++) {
            mask ^= (1 << (cs[i] - '0'));
            masks[i + 1] = mask;
            lastIndices[mask] = i + 1;
        }

        int maxLen = 0;
        for (int i = 0; i <= n; i++) {
            if (maxLen >= n - i)
                break;

            mask = masks[i];

            maxLen = Math.max(maxLen, lastIndices[mask] - i);
            for (int digit = 0; digit < 10; digit++) {
                int newmask = mask ^ (1 << digit);
                maxLen = Math.max(maxLen, lastIndices[newmask] - i);
            }
        }
        return maxLen;
    }
}
