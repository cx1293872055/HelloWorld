package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chenxin
 * @since 2024/5/22 星期三 下午12:56
 */
public class _442 {

    public static void main(String[] args) {

    }

    // 最基础的解法
    // 但是不满足 空间复杂度O(1)
    public static List<Integer> findDuplicates(int[] nums) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (final int num : nums) {
            numMap.put(num, numMap.getOrDefault(num, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();

        for (final Map.Entry<Integer, Integer> entry : numMap.entrySet()) {
            if (entry.getValue() == 2) {
                result.add(entry.getKey());
            }
        }
        return result;
    }

    public static List<Integer> findDuplicates1(int[] nums) {

        List<Integer> result = new ArrayList<>();
        for (final int num : nums) {
            int numAbs = Math.abs(num);
            int num1 = nums[numAbs - 1];
            if (num1 < 0) {
                result.add(numAbs);
            } else {
                nums[numAbs - 1] = -num1;
            }
        }
        return result;
    }
}
