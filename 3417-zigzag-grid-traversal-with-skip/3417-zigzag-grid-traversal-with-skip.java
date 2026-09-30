class Solution {
    public List<Integer> zigzagTraversal(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        List<Integer> list = new ArrayList<>();
        boolean skip = false;

        for (int i = 0; i < n; i++) {

            if (i % 2 == 0) {
                for (int j = 0; j < m; j++) {
                    if (!skip) {
                        list.add(grid[i][j]);
                    }
                    skip = !skip;
                }
            } else {
                for (int j = m - 1; j >= 0; j--) {
                    if (!skip) {
                        list.add(grid[i][j]);
                    }
                    skip = !skip;
                }
            }
        }

        return list;
    }
}