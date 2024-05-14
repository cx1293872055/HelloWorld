package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author chenxin
 * @since 2024/5/13 星期一 上午11:46
 */
public class _994 {

    public static void main(String[] args) {
        System.out.println(orangesRotting(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}));
        System.out.println(orangesRotting(new int[][]{{2, 1, 1}, {0, 1, 1}, {1, 0, 1}}));
    }

    public static int orangesRotting(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;

        int[][] dirs = new int[][]{{-1, 0, 0, 1}, {0, -1, 1, 0}};

        int count = 0;
        int sum = 0;

        Deque<int[]> deque = new ArrayDeque<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    deque.addLast(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    sum++;
                }
            }
        }

        deque.addLast(new int[]{-2, -2});

        while (!deque.isEmpty()) {
            int[] element = deque.pollFirst();
            int x = element[0];
            int y = element[1];

            if (x == -2) {
                count++;
                if (deque.isEmpty()) {
                    break;
                } else {
                    deque.addLast(element);
                    continue;
                }
            }

            for (int i = 0; i < 4; i++) {
                int tempx = x + dirs[0][i];
                int tempy = y + dirs[1][i];

                if (tempx >= 0 && tempx < row && tempy >= 0 && tempy < column && grid[tempx][tempy] == 1) {
                    grid[tempx][tempy] = 2;
                    sum--;
                    deque.addLast(new int[]{tempx, tempy});
                }
            }
        }

        return sum == 0 ? count - 1 : -1;
    }
}
