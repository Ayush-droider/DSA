class Solution {
    long sum=0;
    int[] dr={0,1,0,-1};
    int[] dc={-1,0,1,0};
    private void dfs(int r,int c,boolean[][] vis,int[][] grid){
        sum+=grid[r][c];
        vis[r][c]=true;

        for(int i=0;i<4;i++){
            int nr=r+dr[i];
            int nc=c+dc[i];

            if(nr>=0 && nr < grid.length && nc>=0 && nc<grid[0].length && !vis[nr][nc] && grid[nr][nc]!=0){
                dfs(nr,nc,vis,grid);
            }
        }
    }
    public int countIslands(int[][] grid, int k) {
        boolean[][] vis=new boolean[grid.length][grid[0].length];
        int ans=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]!=0 && !vis[i][j]){
                    sum=0;
                    dfs(i,j,vis,grid);
                    if(sum%k==0)ans++;
                }
            }
        }
        return ans;
    }
}