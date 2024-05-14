package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenxin
 * @since 2024/5/13 星期一 下午6:36
 */
public class _54 {

    public static void main(String[] args) {
        // System.out.println(spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
        System.out.println(spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {

        int row = matrix.length;
        int column = matrix[0].length;
        int l = 0, t = 0, r = column - 1, b = row - 1;
        int number = 1;
        int mult = row * column;

        List<Integer> result = new ArrayList<>();

        while (number <= mult) {
            for (int i = l; i <= r && number <= mult; i++) {
                result.add(matrix[t][i]);
                number++;
            }
            t++;
            for (int i = t; i <= b && number <= mult; i++) {
                result.add(matrix[i][r]);
                number++;
            }
            r--;
            for (int i = r; i >= l && number <= mult; i--) {
                result.add(matrix[b][i]);
                number++;
            }
            b--;
            for (int i = b; i >= t && number <= mult; i--) {
                result.add(matrix[i][l]);
                number++;
            }
            l++;
        }
        return result;
    }
}
