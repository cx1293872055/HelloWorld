package leetcode;

import java.util.Arrays;

/**
 * @author chenxin
 * @since 2024/5/31 星期五 14:38
 */
public class _2965 {

    public static void main(String[] args) {

        // System.out.println(Arrays.toString(findMissingAndRepeatedValues(new int[][]{{1, 3}, {2, 2,}})));
        System.out.println(Arrays.toString(findMissingAndRepeatedValues(new int[][]{{9, 1, 7}, {8, 9, 2}, {3, 4, 6}})));

    }

    public static int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int pn = n * n + 1;

        int[] result = new int[2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num = grid[i][j] % pn;
                int numx = (num - 1) / n;
                int numy = (num - 1) % n;
                if (grid[numx][numy] > pn) {
                    result[0] = num;
                }

                grid[numx][numy] += pn;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] < pn) {
                    result[1] = i * n + j + 1;
                    return result;
                }
            }
        }
        return result;
    }
}
