package leetcode;

/**
 * @author chenxin
 * @since 2024/5/9 星期四 下午3:53
 */
public class _485 {

    public static void main(String[] args) {
        System.out.println(findMaxConsecutiveOnes(new int[]{1, 1, 1, 1, 0, 1, 1, 1, 1, 1}));

    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int count = 0;
        for (final int num : nums) {
            if (num == 0) {
                max = Math.max(max, count);
                count = 0;
            } else {
                count++;
            }
        }
        return Math.max(max, count);
    }
}
