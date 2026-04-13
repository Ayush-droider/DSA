class Solution {
    int[][] grid;
    int m, n;
    Pair[][] memo;

    class Pair {
        long max, min;
        Pair(long max, long min) {
            this.max = max;
            this.min = min;
        }
    }

    public int maxProductPath(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        memo = new Pair[m][n];

        Pair res = solve(0, 0);

        if (res == null || res.max < 0) return -1;
        return (int)(res.max % 1000000007);
    }

    private Pair solve(int i, int j) {
        if (i >= m || j >= n) return null;

        if (i == m - 1 && j == n - 1) {
            return new Pair(grid[i][j], grid[i][j]);
        }

        if (memo[i][j] != null) return memo[i][j];

        Pair right = solve(i, j + 1);
        Pair down = solve(i + 1, j);

        long val = grid[i][j];

        long maxVal = Long.MIN_VALUE;
        long minVal = Long.MAX_VALUE;
        boolean found = false;

        if (right != null) {
            found = true;
            maxVal = Math.max(maxVal, Math.max(val * right.max, val * right.min));
            minVal = Math.min(minVal, Math.min(val * right.max, val * right.min));
        }

        if (down != null) {
            found = true;
            maxVal = Math.max(maxVal, Math.max(val * down.max, val * down.min));
            minVal = Math.min(minVal, Math.min(val * down.max, val * down.min));
        }

        if (!found) return null;

        return memo[i][j] = new Pair(maxVal, minVal);
    }
}