class Solution {
    public class Pair{
        int i;
        int j;

        Pair(int i,int j){
            this.i=i;
            this.j=j;
        }
    }
    int[] dr={0,1,0,-1};
    int[] dc={-1,0,1,0};
    public int[][] updateMatrix(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        int[][] ans=new int[n][m];
        Queue<Pair> q=new LinkedList<>();
        boolean[][] vis=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    q.add(new Pair(i,j));
                    vis[i][j]=true;
                }
            }
        }
        while(!q.isEmpty()){
            int r=q.peek().i;
            int c=q.peek().j;

            q.poll();

            for(int i=0;i<4;i++){
                int row=r+dr[i];
                int col=c+dc[i];

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