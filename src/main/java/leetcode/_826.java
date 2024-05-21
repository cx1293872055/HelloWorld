package leetcode;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author chenxin
 * @since 2024/5/17 星期五 14:53
 */
public class _826 {

    public static void main(String[] args) {
        System.out.println(maxProfitAssignment(new int[]{2, 4, 6, 8, 10},
                                               new int[]{10, 20, 30, 40, 50},
                                               new int[]{4, 5, 6, 7}));
    }

    public static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {

        List<Pair<Integer, Integer>> list = new ArrayList<>();

        for (int i = 0; i < difficulty.length; i++) {
            list.add(new Pair<>(difficulty[i], profit[i]));
        }

        // 按照难度排序
        list.sort(Comparator.comparing(Pair::getKey));
        // 按照工人能力排序
        Arrays.sort(worker);

        int l = difficulty.length;
        // 工作难度的指针
        // 因为工人能力已经从小到大排序,
        // 所以下一个工人能做的工作一定是 >= 上一个工人的,
        int index = 0;
        int result = 0;
        // 所以这个从开始到指针i 的最大的工作收益会持续更新,而不是每次获取新的最大值
        int maxProfit = 0;

        for (final int w : worker) {
            // 每次从上一个工人的指针开始查找,
            while (index < l && list.get(index).getKey() <= w) {
                maxProfit = Math.max(maxProfit, list.get(index).getValue());
                index++;
            }
            result += maxProfit;
        }
        return result;
    }

    public static int maxProfitAssignment3(int[] difficulty, int[] profit, int[] worker) {
        int now_max = 0;
        int m = difficulty.length;
        int max_num = 100001;
        int[] d_p = new int[max_num];
        for (int i = 0; i < m; i++) {
            d_p[difficulty[i]] = Math.max(profit[i], d_p[difficulty[i]]);
        }
        for (int i = 0; i < max_num; i++) {
            if (d_p[i] > now_max) {
                now_max = d_p[i];
            } else {
                d_p[i] = now_max;
            }
            // System.out.println(i + " " + d_p[i]);
        }
        int result = 0;
        for (int i = 0; i < worker.length; i++) {
            result += d_p[worker[i]];
            // System.out.println(d_p[worker[i]]);
        }
        return result;
    }
}
