class Solution{
    int count=0;
     private boolean isSafe(int row,int col,char[][] board,int n){
        int r=row;
        int c=col;
        while(r>=0 && c>=0){
            if(board[r][c]=='Q') return false;
            r--; c--;
        }
        r=row;
        c=col;
        while(c>=0){
            if(board[r][c]=='Q') return false;
            c--;
        }
        r=row;
        c=col;
        while(r<n && c>=0){
            if(board[r][c]=='Q') return false;
            r++; c--;
        }
        return true;
    }
    private void solve(int col,int n,char[][] board){
        if(col==n){
            count++;
            return;
        }
        for(int row=0;row<n;row++){
            if(isSafe(row,col,board,n)){
                board[row][col]='Q';
                solve(col+1,n,board);
                board[row][col]='.';
            }
        }
    }
    public int totalNQueens(int n) {
        char[][] board=new char[n][n];
        for(char[] rows:board){
            Arrays.fill(rows,'.');
        }
        solve(0,n,board);
        return count;
    }
}
