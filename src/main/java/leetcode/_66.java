package leetcode;

import java.util.Arrays;

/**
 * @author chenxin
 * @since 2024/6/7 星期五 下午3:33
 */
public class _66 {

    public static void main(String[] args) {
        // System.out.println(Arrays.toString(plusOne(new int[]{1, 2, 3, 9})));
        System.out.println(Arrays.toString(plusOne(new int[]{0})));

    }

    public static int[] plusOne(int[] digits) {
        int index = digits.length - 1;
        if (!plusIndex(digits, index)) {
            int[] res = new int[index + 2];
            res[0] = 1;
            for (int i = 1; i < res.length; i++) {
                res[i] = 0;
            }
            return res;
        }
        return digits;
    }

    public static boolean plusIndex(int[] nums, int index) {
        if (index >= 0 && nums[index] + 1 == 10) {
            nums[index] = 0;
            return plusIndex(nums, --index);
        } else if (index >= 0) {
            nums[index]++;
            return true;
        } else {
            return false;
        }
    }
}
