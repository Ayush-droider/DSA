class Solution {
    private class Pair{
        int r;
        int c;

        Pair(int r,int c){
            this.r=r;
            this.c=c;
        }
    }

    int[] dr={0,1,0,-1};
    int[] dc={-1,0,1,0};

    private boolean isBorder(int i,int j,int[][] grid,int blueprint){

        if(i==0 || j==0 || i==grid.length-1 || j==grid[0].length-1){
            return true;
        }

        for(int k=0;k<4;k++){
            int row=i+dr[k];
            int col=j+dc[k];

            if(grid[row][col]!=blueprint){
                return true;
            }
        }

        return false;
    }

    private void bfs(int i,int j,int[][] grid,int color,boolean[][] vis,int blueprint){

        Queue<Pair> q=new LinkedList<>();
        List<Pair> border=new ArrayList<>();

        q.add(new Pair(i,j));
        vis[i][j]=true;

        while(!q.isEmpty()){

            Pair p=q.poll();

            int r=p.r;
            int c=p.c;

            if(isBorder(r,c,grid,blueprint)){
                border.add(new Pair(r,c));
            }

            for(int k=0;k<4;k++){

                int row=r+dr[k];
                int col=c+dc[k];

                if(row>=0 && row<grid.length && col>=0 && col<grid[0].length && !vis[row][col] && grid[row][col]==blueprint){
                    q.add(new Pair(row,col));
                    vis[row][col]=true;
                }
            }
        }

        for(Pair p:border){
            grid[p.r][p.c]=color;
        }
    }

    public int[][] colorBorder(int[][] grid,int row,int col,int color){

        int n=grid.length;
        int m=grid[0].length;
        boolean[][] vis=new boolean[n][m];

        int blueprint=grid[row][col];

        bfs(row,col,grid,color,vis,blueprint);
        return grid;
    }
}