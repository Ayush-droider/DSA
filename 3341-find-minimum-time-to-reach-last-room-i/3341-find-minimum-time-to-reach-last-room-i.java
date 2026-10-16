class Solution {
    int[] dr={0,1,0,-1};
    int[] dc={-1,0,1,0};
    private class Pair{
        int r;
        int c;
        int t;
        Pair(int r,int c,int t){
            this.r=r;
            this.c=c;
            this.t=t;
        }
    }
    public int minTimeToReach(int[][] moveTime) {
        int n=moveTime.length;
        int m=moveTime[0].length;
        int[][] time=new int[n][m];
        for(int[] row:time)Arrays.fill(row,Integer.MAX_VALUE);
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->Integer.compare(a.t,b.t));
        pq.add(new Pair(0,0,0));
        time[0][0]=0;
        while(!pq.isEmpty()){
            int row=pq.peek().r;
            int col=pq.peek().c;
            int tm=pq.peek().t;
            pq.poll();

            if(tm>time[row][col])continue;

            if(row==n-1 && col==m-1)return tm;

            for(int i=0;i<4;i++){
                int nrow=row+dr[i];
                int ncol=col+dc[i];

                if(nrow<0 || nrow>=n || ncol<0 || ncol>=m)continue;

                int ntime=Math.max(tm,moveTime[nrow][ncol])+1;

                if(ntime<time[nrow][ncol]){
                    time[nrow][ncol]=ntime;
                    pq.add(new Pair(nrow,ncol,ntime));
                }
            }
        }
        return -1;
    }
}