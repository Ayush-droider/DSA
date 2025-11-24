class Solution {
    public int[] findBall(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        List<Integer> list = new ArrayList<>();

        for(int ball = 0; ball < m; ball++){
            int row = 0;
            int col = ball;
            boolean stuck = false;

            while(row < n){
                if(grid[row][col] == 1){
                    if(col == m-1 || grid[row][col+1] == -1){
                        stuck = true;
                        break;
                    }
                    col++;
                } else {
                    if(col == 0 || grid[row][col-1] == 1){
                        stuck = true;
                        break;
                    }
                    col--;
                }
                row++;
            }

            if(stuck) list.add(-1);
            else list.add(col);
        }

        int[] ans = new int[list.size()];
        for(int i = 0; i < list.size(); i++) ans[i] = list.get(i);

        return ans;
    }
}
