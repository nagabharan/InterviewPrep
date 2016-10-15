package leetcode.matrix;

/**
 * Created by nagabharan on 14-Oct-16.
 */
public class _289GameOfLife {
    public void gameOfLife(int[][] board) {

        if (board == null || board.length == 0 || board[0].length == 0)
            return;

        int[] x = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] y = {0, 1, 1, 1, 0, -1, -1, -1};

        int m = board.length, n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = 0;
                for (int k = 0; k < 8; k++) {
                    int nx = i + x[k], ny = j + y[k];

                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && (board[nx][ny] & 1) == 1)
                        count++;
                }

                //<2 die
                if (count < 2)
                    board[i][j] &= 1;

                //2 or 3 next gen
                if (count == 2 || count == 3)
                    board[i][j] |= board[i][j] << 1;

                //3 new life
                if (count == 3)
                    board[i][j] |= 2;

                //>3 dead
                if (count > 3)
                    board[i][j] &= 1;
            }
        }
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = board[i][j] >> 1;
    }
}
