class Solution {
    int rows, cols;
    boolean found = false;
    int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    boolean dfs(char[][] board, String word, int r, int c, int i) {
        if (i == word.length())
            return true;
        if (r < 0 || c < 0 || r >= rows || c >= cols || word.charAt(i) != board[r][c])
            return false;

        char temp = board[r][c];
        board[r][c] = '*';

        for (int[] d : dirs) {
            if(dfs(board, word, r + d[0], c + d[1], i + 1))
            return true;
        }
        board[r][c] = temp;
        return false;
    }

    public boolean exist(char[][] board, String word) {
        rows = board.length;
        cols = board[0].length;
        boolean solution = false;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, word, i, j, 0))
                        return true;
                }
            }
        }
        return false;
    }
}