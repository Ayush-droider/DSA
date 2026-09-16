class Solution {
    private class Pair{
        int first;
        int second;
        int dis;
        Pair(int first,int second,int dis){
            this.first=first;
            this.second=second;
            this.dis=dis;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        int[][] ans=new int[n][m];
        boolean[][] vis=new boolean[n][m];
        Queue<Pair> q=new LinkedList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    q.add(new Pair(i,j,0));
                    vis[i][j]=true;
                }
            }
        }
        int[] delrow={-1,0,1,0};
        int[] delcol={0,1,0,-1};

        while(!q.isEmpty()){
            int r=q.peek().first;
            int c=q.peek().second;
            int d=q.peek().dis;
            ans[r][c]=d;
            q.remove();

            for(int dir=0;dir<4;dir++){
                int row=r+delrow[dir];
                int col=c+delcol[dir];

                if(row>=0 && col>=0 && row<n && col<m && !vis[row][col]){
                    q.add(new Pair(row,col,d+1));
                    vis[row][col]=true;
                }
            }
        }
        return ans;
    }
}