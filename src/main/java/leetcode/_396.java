package leetcode;

import java.util.Arrays;

/**
 * @author chenxin
 * @since 2024/5/17 星期五 17:16
 */
public class _396 {

    public static void main(String[] args) {
        System.out.println(maxRotateFunction(new int[]{4, 3, 2, 6}));
    }

    public static int maxRotateFunction(int[] nums) {
        int multSum = 0;
        int n = nums.length;
        int numSum = 0;

        for (int i = 0; i < nums.length; i++) {
            multSum += i * nums[i];
            numSum += nums[i];
        }

        int result = multSum;
        for (int i = n - 1; i > 0; i--) {
            multSum = multSum + numSum - n * nums[i];
            result = Math.max(result, multSum);
        }

        return result;
    }

    public static int maxRotateFunction1(int[] nums) {
        int f = 0, n = nums.length, numSum = Arrays.stream(nums).sum();
        for (int i = 0; i < n; i++) {
            f += i * nums[i];
        }
        int res = f;
        for (int i = n - 1; i > 0; i--) {
            f += numSum - n * nums[i];
            res = Math.max(res, f);
        }
        return res;
    }

    public static int maxRotateFunction2(int[] nums) {
        int n = nums.length;
        int[] sum = new int[n * 2 + 10];

        for (int i = 1; i <= 2 * n; i++) {
            sum[i] = sum[i - 1] + nums[(i - 1) % n];
        }

        System.out.println(Arrays.toString(sum));

        int ans = 0;

        for (int i = 1; i <= n; i++) ans += nums[i - 1] * (i - 1);

        for (int i = n + 1, cur = ans; i < 2 * n; i++) {
            cur += nums[(i - 1) % n] * (n - 1);
            cur -= sum[i - 1] - sum[i - n];
            if (cur > ans) ans = cur;
        }
        return ans;
    }
}
