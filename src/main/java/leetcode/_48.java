package leetcode;

import java.util.Arrays;

/**
 * @author chenxin
 * @since 2024/5/13 星期一 下午5:41
 */
public class _48 {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix2 = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        int[][] matrix3 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int[][] matrix4 = {{1, 2, 3, 4, 5},
                           {6, 7, 8, 9, 10},
                           {11, 12, 13, 14, 15},
                           {16, 17, 18, 19, 20},
                           {21, 22, 23, 24, 25}};

        rotate(matrix);
        rotate(matrix2);
        rotate(matrix3);
        rotate(matrix4);

        printArray(matrix);
        printArray(matrix2);
        printArray(matrix3);
        printArray(matrix4);

        // 3 3
        // 0 1
        // 1 0
        // 2 1
        // 1 2
    }

    public static void rotate(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < ((n + 1) / 2); i++) {
            for (int j = 0; j < n / 2; j++) {
                int value = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = value;
            }
        }
    }

    public static void printArray(int[][] a) {
        for (int[] ints : a) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
