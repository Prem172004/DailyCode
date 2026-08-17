class Solution {
    int rows, cols;
    int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    void dfs(int[][] image, int r, int c, int color,int clr) {
        if (r < 0 || c < 0 || r >= rows || c >= cols || image[r][c] != clr)
            return;
        if (image[r][c] == clr)
            image[r][c] = color;
        for (int[] d : dirs) {
            dfs(image, r + d[0], c + d[1], color,clr);
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        rows = image.length;
        cols = image[0].length;
        if(image[sr][sc] == color) return image;
        dfs(image, sr, sc, color,image[sr][sc]);
        return image;
    }
}