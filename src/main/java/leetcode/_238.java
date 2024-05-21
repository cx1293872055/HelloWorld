package leetcode;

import java.util.Arrays;

/**
 * @author chenxin
 * @since 2024/5/17 星期五 15:55
 */
public class _238 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(productExceptSelf(new int[]{-1,1,0,-3,3})));
    }

    public static int[] productExceptSelf(int[] nums) {
        int l = nums.length;
        int[] result = new int[l];

        int multSum = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = multSum;
            multSum *= nums[i];
        }

        int multSum2 = 1;
        for (int i = l - 1; i > -1; i--) {
            result[i] *= multSum2;
            multSum2 *= nums[i];
        }
        return result;
    }
}
