class Solution {
    private class Pair{
        int i;
        int j;
        Pair(int i,int j){
            this.i=i;
            this.j=j;
        }
    }
    int[] dr={0,0,1,-1,1,-1,-1,1};
    int[] dc={1,-1,0,0,1,1,-1,-1};

    private int haveAdjMines(int i,int j,char[][] board){
        int count=0; 

        for(int k=0;k<8;k++){
            int row=i+dr[k];
            int col=j+dc[k];

            if(row>=0 && col>=0 && row<board.length && col<board[0].length){
                if(board[row][col]=='M')count++;
            }
        }
        return count;
    }

    private void bfs(int i,int j,boolean[][] vis,char[][] board){
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(i,j));
        vis[i][j]=true;
        while(!q.isEmpty()){
            Pair p=q.poll();
            int r=p.i;
            int c=p.j;

            if(board[r][c]=='M'){
                board[r][c]='X';
                break;
            }

            int cnt=haveAdjMines(r,c,board);

            if(board[r][c]=='E' && cnt!=0){
                board[r][c]=(char)('0'+cnt);
            }
            else if(board[r][c]=='E' && cnt==0){
                board[r][c]='B';

                for(int k=0;k<8;k++){
                    int row=r+dr[k];
                    int col=c+dc[k];

                    if(row>=0 && col>=0 && row<board.length && col<board[0].length && !vis[row][col] && board[row][col]=='E'){
                        vis[row][col]=true;
                        q.add(new Pair(row,col));
                    }
                }
            }
        }
    }

    public char[][] updateBoard(char[][] board,int[] click){
        boolean[][] vis=new boolean[board.length][board[0].length];
        bfs(click[0],click[1],vis,board);
        return board;
    }
}