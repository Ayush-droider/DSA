class Solution {

    int[] dr={0,1,0,-1};
    int[] dc={-1,0,1,0};

    private boolean dfs(int i,int j,boolean[][] vis,int[][] grid1,int[][] grid2,int n,int m){

        vis[i][j]=true;

        boolean valid=grid1[i][j]==1;

        for(int k=0;k<4;k++){

            int nr=i+dr[k];
            int nc=j+dc[k];

            if(nr>=0 && nr<n && nc>=0 && nc<m && !vis[nr][nc] && grid2[nr][nc]==1){

                if(!dfs(nr,nc,vis,grid1,grid2,n,m)){
                    valid=false;
                }
            }
        }

        return valid;
    }

    public int countSubIslands(int[][] grid1,int[][] grid2){

        int n=grid2.length;
        int m=grid2[0].length;

        boolean[][] vis=new boolean[n][m];

        int island=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid2[i][j]==1 && !vis[i][j]){
                    if(dfs(i,j,vis,grid1,grid2,n,m)){
                        island++;
                    }
                }
            }
        }
        return island;
    }
}