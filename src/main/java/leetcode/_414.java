package leetcode;

import java.util.Arrays;

/**
 * @author chenxin
 * @since 2024/5/9 星期四 上午11:54
 */
public class _414 {

    public static void main(String[] args) {

        System.out.println(thirdMax(new int[]{2, 2, 3, 1}));
        System.out.println(thirdMax(new int[]{3, 2, 1}));
        System.out.println(thirdMax(new int[]{2, 1}));
        System.out.println(thirdMax(new int[]{-3,-2,-1,0}));
        System.out.println(thirdMax(new int[]{1,2147483647,-2147483648}));

    }

    public static int thirdMax(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length - 1;
        int count = 1;
        int preNum = nums[n--];

        while (n > -1) {
            int num = nums[n--];
            if (preNum != num) {
                preNum = num;
                count++;
            }
            if (count == 3) {
                return preNum;
            }
        }

        return nums[nums.length - 1];
    }
}
