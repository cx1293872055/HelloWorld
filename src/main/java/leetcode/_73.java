package leetcode;

import java.util.Arrays;

/**
 * @author chenxin
 * @since 2024/5/14 星期二 下午7:23
 */
public class _73 {

    public static void main(String[] args) {
        int[][] ints1 = {{1, 2, 3, 4}, {5, 0, 7, 8}, {0, 10, 11, 12}, {13, 14, 15, 0}};
        setZeroes(ints1);
        System.out.println(Arrays.deepToString(ints1));

        // int[][] ints = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        // setZeroes(ints);
        // System.out.println(Arrays.deepToString(ints));
    }

    public static void setZeroes(int[][] matrix) {

        boolean columnZero = false;

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                columnZero = true;
            }
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }

        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }

            if (columnZero) {
                matrix[i][0] = 0;
            }
        }
    }
}
