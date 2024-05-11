package leetcode;

import java.util.Arrays;

/**
 * @author chenxin
 * @since 2024/5/11 星期六 下午4:25
 */
public class _661 {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(imageSmoother(new int[][]{{100, 200, 100}, {200, 50, 200},
                                                                         {100, 200, 100}})));

    }

    public static int[][] imageSmoother(int[][] img) {
        int row = img.length, column = img[0].length;
        int[][] result = new int[row][column];
        for (int i = 0; i < img.length; i++) {
            for (int j = 0; j < img[i].length; j++) {
                result[i][j] = smoother(img, i, j);
            }
        }
        return result;
    }

    public static int smoother(int[][] img, int x, int y) {
        int row = img.length, column = img[0].length;

        int minRow = Math.max(0, x - 1);
        int maxRow = Math.min(row - 1, x + 1);

        int minColumn = Math.max(0, y - 1);
        int maxColumn = Math.min(column - 1, y + 1);

        int sum = 0;
        int count = 0;
        for (int i = minRow; i <= maxRow; i++) {
            for (int j = minColumn; j <= maxColumn; j++) {
                sum += img[i][j];
                count++;
            }
        }
        return Math.floorDiv(sum, count);
    }
}
