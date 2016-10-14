package leetcode.matrix;

/**
 * Created by nagabharan on 13-Oct-16.
 */
public class _79WordSearch {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || word.length() == 0)
            return false;

        int m = board.length, n = board[0].length;
        boolean res = false;

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, i, j, 0))
                    res = true;
            }

        return res;
    }

    public boolean dfs(char[][] board, String word, int i, int j, int k) {

        int m = board.length, n = board[0].length;

        if (i < 0 || j < 0 || i >= m || j >= n)
            return false;

        if (board[i][j] == word.charAt(k)) {
            char temp = board[i][j];
            board[i][j] = '#';
            if (k == word.length() - 1)
                return true;
            else if (dfs(board, word, i - 1, j, k + 1) ||
                    dfs(board, word, i + 1, j, k + 1) ||
                    dfs(board, word, i, j - 1, k + 1) ||
                    dfs(board, word, i, j + 1, k + 1))
                return true;
            board[i][j] = temp;
        }
        return false;
    }
}
