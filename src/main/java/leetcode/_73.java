package leetcode;

import java.util.Arrays;

/**
 * @author chenxin
 * @since 2024/5/14 星期二 下午7:23
 */
public class _73 {

    public static void main(String[] args) {
        int[][] ints = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        setZeroes(ints);
        System.out.println(Arrays.deepToString(ints));
    }

    public static void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == -1) {
                    continue;
                }
                if (matrix[i][j] == 0) {
                    for (int ii = 0; ii < m; ii++) {
                        if (matrix[i][ii] != 0) {
                            matrix[i][ii] = -1;
                        }
                    }

                    for (int ii = 0; ii < n; ii++) {
                        if (matrix[ii][j] != 0) {
                            matrix[ii][j] = -1;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
