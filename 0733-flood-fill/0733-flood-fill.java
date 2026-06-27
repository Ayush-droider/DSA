class Solution {

    private void dfs(int i, int j, int[] delrow, int[] delcol,
                     int color, int[][] image, int iniColor) {

        image[i][j] = color;

        for (int d = 0; d < 4; d++) {

            int r = i + delrow[d];
            int c = j + delcol[d];

            if (r >= 0 && r < image.length &&
                c >= 0 && c < image[0].length &&
                image[r][c] == iniColor) {

                dfs(r, c, delrow, delcol, color, image, iniColor);
            }
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int iniColor = image[sr][sc];
        if (iniColor == color)
            return image;

        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};

        dfs(sr, sc, delrow, delcol, color, image, iniColor);

        return image;
    }
}