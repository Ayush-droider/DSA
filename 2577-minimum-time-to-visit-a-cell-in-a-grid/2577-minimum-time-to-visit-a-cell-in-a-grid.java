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

    public int minimumTime(int[][] grid){
        int n=grid.length;
        int m=grid[0].length;

        if(n>1 && grid[1][0]>1 && (m==1 || grid[0][1]>1)){
            return -1;
        }

        PriorityQueue<Pair> pq=new PriorityQueue<>((a, b)->Integer.compare(a.t, b.t));
        int[][] dist=new int[n][m];
        for(int[] row:dist){
            Arrays.fill(row,Integer.MAX_VALUE);
        }

        dist[0][0]=0;
        pq.add(new Pair(0,0,0));

        while(!pq.isEmpty()){
            Pair curr=pq.poll();

            int row=curr.r;
            int col=curr.c;
            int time=curr.t;

            if(time>dist[row][col]) continue;

            if(row==n-1 && col==m-1){
                return time;
            }

            for(int i=0; i<4; i++){
                int nrow=row+dr[i];
                int ncol=col+dc[i];

                if(nrow<0 || nrow>=n || ncol<0 || ncol>=m){
                    continue;
                }

                int newTime=time+1;

                if(newTime<grid[nrow][ncol]){
                    int diff=grid[nrow][ncol]-time;

                    if(diff%2==1){
                        newTime=grid[nrow][ncol];
                    }else{
                        newTime=grid[nrow][ncol]+1;
                    }
                }

                if(newTime<dist[nrow][ncol]){
                    dist[nrow][ncol]=newTime;
                    pq.add(new Pair(nrow, ncol, newTime));
                }
            }
        }
        return -1;
    }
}