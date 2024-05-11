package leetcode;

/**
 * @author chenxin
 * @since 2024/5/11 星期六 下午3:59
 */
public class _645 {

    public static void main(String[] args) {
    }

    public static int[] findErrorNums(int[] nums) {
        int[] temp = new int[nums.length];
        for (final int num : nums) {
            temp[num - 1]++;
        }

        int[] result = new int[2];
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == 2) {
                result[0] = i + 1;
            }
            if (temp[i] == 0) {
                result[1] = i + 1;
            }
        }
        return result;
    }
}
