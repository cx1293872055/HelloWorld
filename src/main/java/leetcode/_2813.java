package leetcode;

import java.util.*;

/**
 * @author chenxin
 * @since 2024/6/13 星期四 下午5:30
 */
public class _2813 {

    public static void main(String[] args) {
        System.out.println(findMaximumElegance(new int[][]{{3, 2}, {8, 1}, {10, 1}}, 2));
    }

    public static long findMaximumElegance(int[][] items, int k) {
        Arrays.sort(items, (a, b) -> b[0] - a[0]);
        long result = 0;
        long totalProfit = 0;
        Set<Integer> types = new HashSet<>();
        Deque<Integer> dups = new ArrayDeque<>();

        for (int i = 0; i < items.length; i++) {
            int profit = items[i][0];
            int category = items[i][1];

            if (i < k) {
                totalProfit += profit;
                if (!types.add(category)) {
                    dups.push(profit);
                }
            } else if (!dups.isEmpty() && types.add(category)) {
                totalProfit += profit - dups.pop();
            }

            result = Math.max(result, totalProfit + (long) types.size() * types.size());
        }
        return result;
    }
}
