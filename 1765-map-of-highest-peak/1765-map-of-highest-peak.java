class Solution {
    private class Pair{
        int i;
        int j;
        int d;
        Pair(int i,int j,int d){
            this.i=i;
            this.j=j;
            this.d=d;
        }
    }
    int[] dr={0,1,0,-1};
    int[] dc={-1,0,1,0};

    public int[][] highestPeak(int[][] mat){
        int n=mat.length;
        int m=mat[0].length;
        int[][] ans=new int[n][m];
        boolean[][] vis=new boolean[n][m];
        Queue<Pair> q=new LinkedList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==1){
                    vis[i][j]=true;
                    q.add(new Pair(i,j,0));
                }
            }
        }
        while(!q.isEmpty()){
            Pair p=q.poll();
            int r=p.i;
            int c=p.j;
            int dis=p.d;

            ans[r][c]=dis;

            for(int k=0;k<4;k++){
                int row=r+dr[k];
                int col=c+dc[k];

                if(row>=0 && row<n && col>=0 && col<m && !vis[row][col]){
                    vis[row][col]=true;
                    q.add(new Pair(row,col,dis+1));
                }
            }
        }
        return ans;
    }
}