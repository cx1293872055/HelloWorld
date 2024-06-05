package leetcode;

/**
 * @author chenxin
 * @since 2024/5/22 星期三 下午5:25
 */
public class _665 {

    public static void main(String[] args) {
        System.out.println(checkPossibility(new int[]{4, 2, 3}));
        System.out.println(checkPossibility(new int[]{4, 2, 1}));
        System.out.println(checkPossibility(new int[]{3, 4, 2, 3}));
    }

    public static boolean checkPossibility(int[] nums) {

        boolean fail = false;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                if (fail) {
                    return false;
                }
                if (i > 0 && nums[i - 1] > nums[i + 1]) {
                    nums[i + 1] = nums[i];
                }
                fail = true;
            }
        }

        return true;
    }
}
