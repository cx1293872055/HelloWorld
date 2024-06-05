package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chenxin
 * @since 2024/5/22 星期三 上午11:47
 */
public class _2225 {

    public static void main(String[] args) {

    }

    public static List<List<Integer>> findWinners(int[][] matches) {

        Map<Integer, int[]> numMap = new HashMap<>();

        for (final int[] match : matches) {
            int winner = match[0];
            int loser = match[1];

            numMap.computeIfAbsent(winner, k -> new int[]{0,0})[0]++;
            numMap.computeIfAbsent(loser, k -> new int[]{0,0})[1]++;
        }

        List<Integer> winAll = new ArrayList<>();
        List<Integer> loseOne = new ArrayList<>();

        for (final Map.Entry<Integer, int[]> entry : numMap.entrySet()) {
            Integer num = entry.getKey();
            int[] value = entry.getValue();

            if (value[1] == 0) {
                winAll.add(num);
            }
            if (value[1] == 1) {
                loseOne.add(num);
            }
        }

        List<List<Integer>> result = new ArrayList<>();

        winAll.sort(Integer::compareTo);
        loseOne.sort(Integer::compareTo);

        result.add(winAll);
        result.add(loseOne);

        return result;
    }
}
