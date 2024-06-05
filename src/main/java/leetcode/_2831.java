package leetcode;

import kotlin.collections.CollectionsKt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chenxin
 * @since 2024/5/23 星期四 下午4:02
 */
public class _2831 {

    public static void main(String[] args) {
        System.out.println(longestEqualSubarray(CollectionsKt.arrayListOf(1, 3, 2, 3, 1, 3), 3));
    }

    public static int longestEqualSubarray(List<Integer> nums, int k) {
        Map<Integer, List<Integer>> numMap = new HashMap<>();
        for (int i = 0; i < nums.size(); i++) {
            numMap.computeIfAbsent(nums.get(i), x -> new ArrayList<>()).add(i);
        }

        int result = 0;

        for (final List<Integer> value : numMap.values()) {
            for (int i = 0, j = 0; i < value.size(); i++) {
                while (value.get(i) - value.get(j) - (i - j) > k) {
                    j++;
                }
                result = Math.max(result, i - j + 1);
            }
        }

        return result;
    }

    public static int longestEqualSubarray1(List<Integer> nums, int k) {
        int n = nums.size();

        return 01;
    }
}
