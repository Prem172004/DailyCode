class Solution {
    void dfs(char[][] board, int r, int c) {
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != 'O')
            return;
        board[r][c] = 'S';
        dfs(board, r + 1, c);
        dfs(board, r - 1, c);
        dfs(board, r, c + 1);
        dfs(board, r, c - 1);

    }

    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        for(int r = 0; r < rows; r++) {
            if(board[r][0] == 'O') dfs(board, r, 0);
            if(board[r][cols-1] == 'O') dfs(board, r, cols-1);
        }
        for(int c = 0; c < cols; c++) {
            if(board[0][c] == 'O') dfs(board, 0, c);
            if(board[rows-1][c] == 'O') dfs(board, rows-1, c);
        }

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(board[i][j] == 'O') board[i][j] = 'X';
                else if(board[i][j] == 'S') board[i][j] = 'O';
            }
        }

    }
}