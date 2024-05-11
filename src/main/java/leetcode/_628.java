package leetcode;

import java.util.Arrays;

/**
 * @author chenxin
 * @since 2024/5/11 星期六 下午3:47
 */
public class _628 {

    public static void main(String[] args) {

        System.out.println(maximumProduct(new int[]{1, 2, 3}));
        System.out.println(maximumProduct(new int[]{1, 2, 3, 4}));
        System.out.println(maximumProduct(new int[]{-1, -2, -3}));
        System.out.println(maximumProduct(new int[]{1, 0, 3}));
        System.out.println(maximumProduct(new int[]{1, 2, 3, 0}));
        System.out.println(maximumProduct(new int[]{1, 3, -1, 0}));

    }

    public static int maximumProduct(int[] nums) {
        Arrays.sort(nums);

        int first = nums[0];
        int second = nums[1];
        int minusThird = nums[nums.length - 3];
        int minusSecond = nums[nums.length - 2];
        int minusFirst = nums[nums.length - 1];

        return Math.max(first * second * minusFirst, minusThird * minusSecond * minusFirst);
    }
}
