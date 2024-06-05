package leetcode;

import java.util.Arrays;

/**
 * @author chenxin
 * @since 2024/5/22 星期三 下午3:45
 */
public class _498 {

    public static void main(String[] args) {
        // System.out.println(Arrays.toString(findDiagonalOrder1(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}})));
        System.out.println(Arrays.toString(findDiagonalOrder1(new int[][]{{3}, {2}})));
    }

    public static int[] findDiagonalOrder(int[][] mat) {
        int[][] dirs = new int[][]{{-1, 1}, {1, -1}};
        int row = mat.length;
        int column = mat[0].length;
        int size = row * column;
        int[] result = new int[size];
        int x = 0, y = 0;
        int index = 0;
        int dir = 0;

        while (index < size) {
            result[index++] = mat[x][y];

            int nextx = x + dirs[dir][0];
            int nexty = y + dirs[dir][1];

            if (nextx < 0 || nexty >= column) {
                dir ^= 1;
                if (y + 1 < column) {
                    y++;
                } else {
                    x++;
                }
            } else if (nexty < 0 || nextx >= row) {
                dir ^= 1;
                if (x + 1 < row) {
                    x++;
                } else {
                    y++;
                }
            } else {
                x = nextx;
                y = nexty;
            }
        }

        return result;
    }

    public static int[] findDiagonalOrder1(int[][] mat) {
        int row = mat.length;
        int column = mat[0].length;
        int[] result = new int[row * column];
        int index = 0;

        for (int i = 0; i < row + column - 1; i++) {
            if (i % 2 == 0) {
                int x = i < row ? i : row - 1;
                int y = i < row ? 0 : i - row + 1;
                while (x >= 0 && y < column) {
                    result[index++] = mat[x--][y++];
                }
            } else {
                int x = i < column ? 0 : i - column + 1;
                int y = i < column ? i : column - 1;
                while (x < row && y >= 0) {
                    result[index++] = mat[x++][y--];
                }
            }
        }
        return result;
    }
}
