package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenxin
 * @since 2024/5/11 星期六 下午4:58
 */
public class _697 {

    public static void main(String[] args) {
        System.out.println(findShortestSubArray(new int[]{1,3,2,2,3,1}));
    }

    public static int findShortestSubArray(int[] nums) {
        Map<Integer, int[]> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(num)) {
                int[] ints = map.get(num);
                ints[0]++;
                ints[2] = i;
            } else {
                map.put(num, new int[]{1, i, i});
            }
        }

        int maxLen = 0;
        int minLen = Integer.MAX_VALUE;

        for (final int[] array : map.values()) {

            if (array[0] > maxLen) {
                maxLen = array[0];
                minLen = array[2] - array[1] + 1;
            } else if (array[0] == maxLen) {
                minLen = Math.min(minLen, array[2] - array[1] + 1);
            }
        }
        return minLen;
    }
}
