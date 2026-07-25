class Solution {
    List<List<String>> ans=new ArrayList<>();
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
            List<String> temp=new ArrayList<>();
            for(char[] row:board){
                temp.add(new String(row));
            }
            ans.add(new ArrayList<>(temp));
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
    public List<List<String>> solveNQueens(int n) {
        char[][] board=new char[n][n];
        for(char[] rows:board){
            Arrays.fill(rows,'.');
        }
        solve(0,n,board);
        return ans;
    }
}