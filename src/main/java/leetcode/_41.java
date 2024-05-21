package leetcode;

/**
 * @author chenxin
 * @since 2024/5/17 星期五 18:23
 */
public class _41 {

    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{1,2,0}));
    }
    public static int firstMissingPositive(int[] nums) {
        int l = nums.length;

        // 将<=的值 设为 l + 1
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                nums[i] = l + 1;
            }
        }
        // 遍历数组,如果值在[1,l]中则将数组的值所在的下标设置为当前数的反值
        // 那么剩下的正整数中的第一个下标就是最小的缺失的正整数
        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);
            if (num <= l) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        // 遍历找到第一个正整数的下标
        // 如果没有,那么说明这个数组中的值[1,l]都出现了,那么就是 l + 1
        int result = l + 1;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num > 0) {
                result = i + 1;
                break;
            }
        }
        return result;
    }
}
