class Solution {
    public boolean isSafe(int row,int col,List<String> board,int n){
        int r=row;
        int c=col;
        while(r>=0 && c>=0){
            if(board.get(r).charAt(c)=='Q') return false;
            r--; c--;
        }
        r=row;
        c=col;
        while(c>=0){
            if(board.get(r).charAt(c)=='Q') return false;
            c--;
        }
        r=row;
        c=col;
        while(r<n && c>=0){
            if(board.get(r).charAt(c)=='Q') return false;
            r++; c--;
        }
        return true;
    }

    public void solve(int col,List<String> board,List<List<String>> ans,int n){
        if(col==n){
            ans.add(new ArrayList<>(board));
            return;
        }
        for(int row=0;row<n;row++){
            if(isSafe(row,col,board,n)){
                char[] temp = board.get(row).toCharArray();
                temp[col] = 'Q';
                board.set(row,new String(temp));
                solve(col+1,board,ans,n);
                temp[col] = '.';
                board.set(row,new String(temp));
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans=new ArrayList<>();
        List<String> board=new ArrayList<>();
        for(int i=0;i<n;i++){
            String s="";
            for(int j=0;j<n;j++) s+=".";
            board.add(s);
        }
        solve(0,board,ans,n);
        return ans;
    }
}
