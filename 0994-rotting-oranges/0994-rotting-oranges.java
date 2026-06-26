class Solution {
    private class pair{
        int r;
        int c;
        int tm;
        pair(int r,int c,int tm){
            this.r=r;
            this.c=c;
            this.tm=tm;
        }
    }
    public int orangesRotting(int[][] grid) {
        int countFresh=0;
        int rotten=0;
        int n=grid.length;
        int m=grid[0].length;
        Queue<pair> q=new LinkedList<>();
        boolean[][] vis=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1)countFresh++;
                else if(grid[i][j]==2){
                    vis[i][j]=true;
                    q.add(new pair(i,j,0));
                }
            }
        }
        int time=0;
        int[] delrow={-1,0,1,0};
        int[] delcol={0,1,0,-1};
        while(!q.isEmpty()){
            pair p=q.poll();
            int r=p.r;
            int c=p.c;
            int tm=p.tm;
            time=Math.max(time,tm);

            for(int i=0;i<4;i++){
                int row=r+delrow[i];
                int col=c+delcol[i];

                if(row>=0 && row<n && col>=0 && col<m && grid[row][col]==1 && !vis[row][col]){
                    q.offer(new pair(row,col,tm+1));
                    vis[row][col]=true;
                    rotten++;
                }
            }
        }
        return (rotten==countFresh)?time:-1;
    }
}