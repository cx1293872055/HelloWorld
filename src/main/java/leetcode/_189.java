package leetcode;

import java.util.Arrays;

/**
 * @author chenxin
 * @since 2024/5/16 星期四 下午5:40
 */
public class _189 {

    public static void main(String[] args) {

        int[] ints = {1, 2, 3, 4, 5, 6, 7};
        rotate(ints, 4);
        System.out.println(Arrays.toString(ints));
    }

    public static int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
    }

    public static void rotate(int[] nums, int k) {
        int l = nums.length;

        if (k % l == 0) {
            return;
        }

        int step = k % l;

        int count = gcd(l, step);

        for (int i = 0; i < count; i++) {
            int index = i;
            int preVal = nums[index];
            do {
                index = (index + step) % l;
                int temp = nums[index];
                nums[index] = preVal;
                preVal = temp;
            } while (index != i);
        }
    }
}
