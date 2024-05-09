package leetcode;

import java.util.Arrays;

/**
 * @author chenxin
 * @since 2024/5/9 星期四 下午4:14
 */
public class _566 {

    public static void main(String[] args) {

        System.out.println(Arrays.deepToString(matrixReshape(new int[][]{{1, 2}, {3, 4}}, 1, 4)));
        System.out.println(Arrays.deepToString(matrixReshape(new int[][]{{1, 2}, {3, 4}}, 2, 4)));
        System.out.println(Arrays.deepToString(matrixReshape(new int[][]{{1, 2}, {3, 4}}, 4, 1)));

    }

    public static int[][] matrixReshape(int[][] mat, int r, int c) {

        int rowL = mat.length;
        int colL = mat[0].length;

        if (r * c != rowL * colL) {
            return mat;
        }

        int[][] result = new int[r][c];
        int x = 0, y = 0;

        for (final int[] ints : mat) {
            for (final int anInt : ints) {
                int tempY = y % c;
                result[x][tempY] = anInt;
                if (++y == c) {
                    x++;
                    y = 0;
                }
            }
        }

        return result;
    }
}
