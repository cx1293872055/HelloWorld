package leetcode;

/**
 * @author chenxin
 * @since 2024/6/7 星期五 下午3:17
 */
public class _3038 {

    public static void main(String[] args) {
        System.out.println(maxOperations(new int[]{3, 2, 1, 4, 3, 2}));
    }

    public static int maxOperations(int[] nums) {
        int result = 0;
        int i = 0;
        int sum = 0;

        while (i < nums.length - 1) {
            int tempSum = nums[i++] + nums[i++];
            if (sum == 0) {
                sum = tempSum;
                result++;
                continue;
            }

            if (sum == tempSum) {
                result++;
            } else {
                break;
            }
        }
        return result;
    }
}
