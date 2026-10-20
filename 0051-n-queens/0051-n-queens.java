class Solution {
    List<List<String>> list=new ArrayList<>();
    private boolean isSafe(int i,int j,char[][] board){
        int r=0,c=0;
        //down-right diagonal
        r=i;c=j;
        while(r>=0 && c>=0){
            if(board[r][c]=='Q')return false;
            r--;
            c--;
        }
        //upper-left
        r=i;c=j;
        while(c>=0){
            if(board[r][c]=='Q')return false;
            c--;
        }
        //upper right
        r=i;c=j;
        while(r<board.length && c>=0){
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
            list.add(temp);
            return;
        }
        for(int row=0;row<n;row++){
            if(isSafe(row,col,board)){
                board[row][col]='Q';
                solve(col+1,n,board);
                board[row][col]='.';
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        char[][] board=new char[n][n];
        for(char[] row:board){
            Arrays.fill(row,'.');
        }
        solve(0,n,board);
        return list;
    }
}