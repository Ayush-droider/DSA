class Solution {
    private class Pair{
        int i;
        int j;
        Pair(int i,int j){
            this.i=i;
            this.j=j;
        }
    }
    int[] dr={0,1,0,-1};
    int[] dc={-1,0,1,0};

    public int[][] updateMatrix(int[][] mat){
        int n=mat.length;
        int m=mat[0].length;
        int[][] ans=new int[n][m];
        boolean[][] vis=new boolean[n][m];
        Queue<Pair> q=new LinkedList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    vis[i][j]=true;
                    q.add(new Pair(i,j));
                }
            }
        }
        while(!q.isEmpty()){
            Pair p=q.poll();
            int r=p.i;
            int c=p.j;

            for(int k=0;k<4;k++){
                int row=r+dr[k];
                int col=c+dc[k];

                if(row>=0 && row<n && col>=0 && col<m && !vis[row][col]){
                    vis[row][col]=true;
                    ans[row][col]=ans[r][c]+1;
                    q.add(new Pair(row,col));
                }
            }
        }
        return ans;
    }
}