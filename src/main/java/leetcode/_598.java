package leetcode;

/**
 * @author chenxin
 * @since 2024/5/9 星期四 下午4:30
 */
public class _598 {

    public static void main(String[] args) {
        System.out.println(maxCount(3, 3, new int[][]{{2, 2}, {3, 3}, {3, 3}, {3, 3}, {2, 2}, {3, 3}, {3, 3}, {3, 3},
                                                      {2, 2}, {3, 3}, {3, 3}, {3, 3}}));
        System.out.println(maxCount(3, 3, new int[][]{}));
    }

    public static int maxCount(int m, int n, int[][] ops) {
        int mina = m, minb = n;

        for (final int[] op : ops) {
            mina = Math.min(mina, op[0]);
            minb = Math.min(minb, op[1]);
        }

        return mina * minb;
    }
}
