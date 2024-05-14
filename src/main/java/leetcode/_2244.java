package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenxin
 * @since 2024/5/14 星期二 下午7:00
 */
public class _2244 {

    public static void main(String[] args) {

        System.out.println(minimumRounds(new int[]{66, 66, 63, 61, 63, 63, 64, 66, 66, 65, 66, 65, 61, 67, 68, 66, 62,
                                                   67, 61, 64, 66, 60, 69, 66, 65, 68, 63, 60, 67, 62, 68, 60, 66, 64,
                                                   60, 60, 60, 62, 66, 64, 63, 65, 60, 69, 63, 68, 68, 69, 68, 61}));
    }

    public static int minimumRounds(int[] tasks) {

        Map<Integer, Integer> map = new HashMap<>();

        for (final int task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }

        int result = 0;

        for (final Integer value : map.values()) {

            if (value == 1) {
                return -1;
            }

            if (value % 3 == 0) {
                result += value / 3;
            } else {
                result += value / 3 + 1;
            }
        }

        return result;
    }
}
