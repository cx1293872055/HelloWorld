package leetcode;

import java.util.Arrays;

/**
 * @author chenxin
 * @since 2024/5/17 星期五 16:51
 */
public class _289 {

    public static void main(String[] args) {
        int[][] ints = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        gameOfLife(ints);
        System.out.println(Arrays.deepToString(ints));
    }

    public static void gameOfLife(int[][] board) {

        // 0 -> 1 : 2
        // 1 -> 0 : 3
        int[][] dirs = {{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}};
        int row = board.length;
        int column = board[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {

                int count = 0;
                for (final int[] dir : dirs) {
                    int tempx = i + dir[0];
                    int tempy = j + dir[1];
                    if (tempx >= 0 && tempx < row && tempy >= 0 && tempy < column) {
                        if (board[tempx][tempy] == 1 || board[tempx][tempy] == 3) {
                            count++;
                        }
                    }
                }

                if (board[i][j] == 1 && count != 2 && count != 3) {
                    board[i][j] = 3;
                }
                if (board[i][j] == 0 && count == 3) {
                    board[i][j] = 2;
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 1;
                }
                if (board[i][j] == 3) {
                    board[i][j] = 0;
                }
            }
        }
    }
}

