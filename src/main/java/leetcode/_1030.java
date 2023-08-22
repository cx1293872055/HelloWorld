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

    /**
     * 先计算出最大的距离
     *
     * 从距离1的点开始知道最大距离的点
     * step 为每次计算的距离
     *
     * 每一层从 {rCenter + step ,cCenter} 开始
     * 直到回到 {rCenter + step ,cCenter} 结束一层遍历
     * 步骤 方向为 右下角 -> 左下角 -> 左上角 -> 右上角
     * 每次走到和rCenter,cCenter在同一水平线或同一垂直线时换方向。
     * 换了三次方向后，代表走一圈，在第四次换方向时结束一圈的遍历。
     */

    public static int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {

        int[][] result = new int[rows * cols][2];
        int[][] diretion = new int[][]{{1, -1}, {-1, -1}, {-1, 1}, {1, 1}};

        int step = 1;
        int count = 0;
        result[count++] = new int[]{rCenter, cCenter};

        int max = Math.addExact(Math.max(rows - rCenter - 1, rCenter), Math.max(cols - cCenter - 1, cCenter));

        while (step <= max) {

            int startR = rCenter;
            int startC = cCenter + step;
            int direc = 0;

            while (direc < 4) {

                startR = startR + diretion[direc][0];
                startC = startC + diretion[direc][1];

                if (startR >= 0 && startR < rows && startC >= 0 && startC < cols) {
                    result[count++] = new int[]{startR, startC};
                }

                if (startR == rCenter || startC == cCenter) {
                    direc++;
                }
            }

            step++;
        }
        return result;
    }


}
