package leetcode;

import java.util.Arrays;

/**
 * @author chenxin
 * @date 2023/8/21 星期一 16:10
 */
public class _1030 {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(allCellsDistOrder(1, 2, 0, 0)));
    }

    public static int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {

        int[][] result = new int[rows * cols][2];

        int step = 1;
        int count = 0;
        result[count++] = new int[]{rCenter, cCenter};

        int max = Math.max(Math.max(rows - rCenter - 1, rCenter), Math.max(cols - cCenter - 1, cCenter));

        while (step <= max) {

            int left = rCenter - step;
            int down = cCenter - step;
            int right = rCenter + step;
            int top = cCenter + step;

            if (top < cols) {
                for (int i = left; i < right; i++) {
                    if (i >= 0 && i < rows) result[count++] = new int[]{i, top};
                }
            }
            if (right < rows) {
                for (int i = top; i > down; i--) {
                    if (i >= 0 && i < cols) result[count++] = new int[]{right, i};
                }
            }
            if (down >= 0) {
                for (int i = right; i > left; i--) {
                    if (i >= 0 && i < rows) result[count++] = new int[]{i, down};
                }
            }
            if (left >= 0) {
                for (int i = down; i < top; i++) {
                    if (i >= 0 && i < cols) result[count++] = new int[]{left, i};
                }
            }

            step++;
        }
        return result;
    }


}
