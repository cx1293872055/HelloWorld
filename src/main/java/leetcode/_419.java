package leetcode;

/**
 * @author chenxin
 * @since 2024/5/21 星期二 下午6:36
 */
public class _419 {

    public static void main(String[] args) {

        System.out.println(countBattleships(new char[][]{{'X', '.', '.', 'X'},
                                                         {'.', '.', '.', 'X'},
                                                         {'.', '.', '.', 'X'}}));
    }

    public static int countBattleships(char[][] board) {

        int result = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'X') {
                    if (i > 0 && board[i - 1][j] == 'X') {
                        continue;
                    }
                    if (j > 0 && board[i][j - 1] == 'X') {
                        continue;
                    }
                    result++;
                }
            }
        }
        return result;
    }
}
