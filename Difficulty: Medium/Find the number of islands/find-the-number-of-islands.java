class Solution {
    class Pair{
        int first;
        int second;
        Pair(int first,int second){
            this.first=first;
            this.second=second;
        }
    }
    public void bfs(int row,int col,char[][] grid,boolean[][] vis){
        vis[row][col]=true;
        int ro=row;
        int co=col;
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(ro,co));
        int n=grid.length;
        int m=grid[0].length;
        
        while(!q.isEmpty()){
            int r=q.peek().first;
            int c=q.peek().second;
            q.remove();
            
            for(int delrow=-1;delrow<=1;delrow++){
                for(int delcol=-1;delcol<=1;delcol++){
                    int nrow=r+delrow;
                    int ncol=c+delcol;
                    
                    if(nrow>=0 && ncol>=0 && nrow<n && ncol<m && !vis[nrow][ncol] && grid[nrow][ncol]=='L'){
                        vis[nrow][ncol]=true;
                        q.add(new Pair(nrow,ncol));
                    }
                }
            }
        }
    }
    public int countIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        
        boolean[][] visited=new boolean[n][m];
        
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j] && grid[i][j]=='L'){
                    bfs(i,j,grid,visited);
                    cnt++;
                }
            }
        }
        return cnt;
    }
}