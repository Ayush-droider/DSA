class Solution {
    private boolean dfs(int idx,int r,int c,boolean[][] vis,int[] delrow,int[] delcol,char[][] board,String word){
        if(idx==word.length()-1)return true;
        int n=board.length;
        int m=board[0].length;

        vis[r][c]=true;
        for(int i=0;i<4;i++){
            int ro=r+delrow[i];
            int co=c+delcol[i];

            if(ro>=0 && ro<n && co>=0 && co<m && !vis[ro][co] && word.charAt(idx+1)==board[ro][co]){
                if(dfs(idx+1,ro,co,vis,delrow,delcol,board,word))return true;
            }
        }
        vis[r][c]=false;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        int n=board.length;
        int m=board[0].length;

        int[] delrow={-1,0,1,0};
        int[] delcol={0,1,0,-1};
        boolean[][] vis=new boolean[board.length][board[0].length];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                char ch=word.charAt(0);
                if(board[i][j]==ch){
                    if(dfs(0,i,j,vis,delrow,delcol,board,word))return true;
                }
            }
        }
        return false;
    }
}