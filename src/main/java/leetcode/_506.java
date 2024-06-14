package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chenxin
 * @since 2024/6/14 星期五 下午5:54
 */
public class _506 {

    public static void main(String[] args) {

    }

    public static String[] findRelativeRanks(int[] score) {

        int[] clone = score.clone();
        int len = score.length;
        Arrays.sort(score);

        Map<Integer, Integer> orderMap = new HashMap<>();

        for (int j = 0; j < score.length; j++) {
            orderMap.put(score[j], len - j);
        }

        String[] result = new String[len];

        for (int i = 0; i < clone.length; i++) {
            Integer order = orderMap.get(clone[i]);
            switch (order) {
                case 1:
                    result[i] = "Gold Medal";
                    break;
                case 2:
                    result[i] = "Silver Medal";
                    break;
                case 3:
                    result[i] = "Bronze Medal";
                    break;
                default:
                    result[i] = String.valueOf(order);
            }
        }
        return result;
    }
}
