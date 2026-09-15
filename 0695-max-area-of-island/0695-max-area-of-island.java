class Solution {
    int[] dr={0,1,0,-1};
    int[] dc={-1,0,1,0};
    private int dfs(int i,int j,boolean[][] vis,int[][] grid){
        int count=1;
        vis[i][j]=true;
        for(int k=0;k<4;k++){
            int row=i+dr[k];
            int col=j+dc[k];
            if(row>=0 && row<grid.length && col>=0 && col<grid[0].length && !vis[row][col] && grid[row][col]==1){
                count+=dfs(row,col,vis,grid);
            }
        }
        return count;
    }
    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] vis=new boolean[grid.length][grid[0].length];
        int maxi=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1 && !vis[i][j]){
                    int ans=dfs(i,j,vis,grid);
                    maxi=Math.max(ans,maxi);
                }
            }
        }
        return maxi;
    }
}