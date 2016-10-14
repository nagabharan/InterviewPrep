package leetcode.matrix;

import java.util.LinkedList;

/**
 * Created by nagabharan on 13-Oct-16.
 */
public class _130SurroundedRegions {
    public void solve(char[][] board) {

        if (board == null || board.length == 0 || board[0].length == 0)
            return;

        int m = board.length, n = board[0].length;

        // Merge left and right 0s
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O')
                bfs(board, 0, j);
        }
        for (int j = 0; j < n; j++) {
            if (board[m - 1][j] == 'O')
                bfs(board, m - 1, j);
        }

        //Merge top and bottom 0s
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O')
                bfs(board, i, 0);
        }
        for (int i = 0; i < m; i++) {
            if (board[i][n - 1] == 'O')
                bfs(board, i, n - 1);
        }

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                if (board[i][j] == '1')
                    board[i][j] = 'O';
            }
    }

    public void bfs(char[][] board, int p, int q) {

        int m = board.length, n = board[0].length;

        int index = p * n + q;
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(index);

        board[p][q] = '1';

        while (!queue.isEmpty()) {
            int top = queue.remove();
            int i = top / n;
            int j = top % n;

            if (i - 1 >= 0 && board[i - 1][j] == 'O') {
                board[i - 1][j] = '1';
                queue.add((i - 1) * n + j);
            }

            if (i + 1 < m && board[i + 1][j] == 'O') {
                board[i + 1][j] = '1';
                queue.add((i + 1) * n + j);
            }

            if (j - 1 >= 0 && board[i][j - 1] == 'O') {
                board[i][j - 1] = '1';
                queue.add(i * n + j - 1);
            }

            if (j + 1 < n && board[i][j + 1] == 'O') {
                board[i][j + 1] = '1';
                queue.add(i * n + j + 1);
            }
        }
    }
}
