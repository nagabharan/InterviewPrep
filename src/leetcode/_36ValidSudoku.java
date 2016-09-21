package leetcode;

import java.util.HashSet;

/**
 * Created by nagabharan on 20-Sep-16.
 */
public class _36ValidSudoku {
    static boolean isValidSudoku(char[][] board) {
        HashSet<Character> set1, set2;
        for (int i = 0; i < 9; i++) {
            set1 = new HashSet<>();
            set2 = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (!set1.add(board[i][j]) && board[i][j] != '.')
                    return false;
                if (!set2.add(board[j][i]) && board[j][i] != '.')
                    return false;
            }
        }
        for (int x = 0; x < 9; x += 3) {
            for (int y = 0; y < 9; y += 3) {
                set1 = new HashSet<>();
                for (int i = x; i < x + 3; i++) {
                    for (int j = y; j < y + 3; j++) {
                        if (!set1.add(board[i][j]) && board[i][j] != '.')
                            return false;
                    }
                }
            }
        }
        return true;
    }
}
