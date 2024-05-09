package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenxin
 * @since 2024/5/9 星期四 下午2:06
 */
public class _448 {

    public static void main(String[] args) {

        System.out.println(findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));

    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;

        for (final int num : nums) {
            nums[(num - 1) % n] += n;
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= n) {
                result.add(i + 1);
            }
        }
        return result;
    }
}

