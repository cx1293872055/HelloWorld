package leetcode;

import java.util.Arrays;

/**
 * @author chenxin
 * @since 2024/5/9 星期四 上午10:42
 */
public class _283 {

    public static void main(String[] args) {
        {
            int[] ints = {0, 1, 0, 3, 12};
            moveZeroes(ints);
            System.out.println(Arrays.toString(ints));
        }
        {
            int[] ints = {1};
            moveZeroes(ints);
            System.out.println(Arrays.toString(ints));
        }
        {
            int[] ints = {1, 2};
            moveZeroes(ints);
            System.out.println(Arrays.toString(ints));
        }
    }

    //	执行耗时:1 ms,击败了99.99% 的Java用户
    // 	内存消耗:44.8 MB,击败了82.14% 的Java用户
    public static void moveZeroes(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count++;
            } else {
                nums[i - count] = nums[i];
            }
        }

        int last = nums.length - 1;

        for (int i = 0; i < count; i++) {
            nums[last - i] = 0;
        }
    }

    // 	执行耗时:1 ms,击败了99.99% 的Java用户
    // 	内存消耗:44.8 MB,击败了82.14% 的Java用户
    // public static void moveZeroes(int[] nums) {
    //     int count = 0;
    //     for (int i = 0; i < nums.length; i++) {
    //         if (nums[i] != 0) {
    //             nums[count] = nums[i];
    //             if (count++ != i) {
    //                 nums[i] = 0;
    //             }
    //         }
    //     }
    // }

    // 	执行耗时:2 ms,击败了32.70% 的Java用户
    // 	内存消耗:44.9 MB,击败了80.96% 的Java用户
    // public void moveZeroes(int[] nums) {
    //         int left = 0, right = 0;
    //
    //         while (right < nums.length) {
    //             if (nums[right] != 0) {
    //                 swap(nums, left++, right);
    //             }
    //             right++;
    //         }
    //     }
    //
    //     public  void swap(int[] ints, int a, int b) {
    //         if (a == b) {
    //             return;
    //         }
    //
    //         int temp = ints[a];
    //         ints[a] = ints[b];
    //         ints[b] = temp;
    //     }
}
