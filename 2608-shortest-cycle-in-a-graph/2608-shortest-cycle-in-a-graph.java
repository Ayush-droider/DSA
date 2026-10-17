class Solution {
    int minCycleDistance=Integer.MAX_VALUE;
    public int findShortestCycle(int n, int[][] edges) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] u:edges){
            adj.get(u[0]).add(u[1]);
            adj.get(u[1]).add(u[0]);
        }
        for(int src=0;src<n;src++){
            int[] dis=new int[n];
            int[] par=new int[n];

            Arrays.fill(dis,-1);
            Arrays.fill(par,-1);

            Queue<Integer> q=new LinkedList<>();
            dis[src]=0;
            q.add(src);

            while(!q.isEmpty()){
                int u=q.poll();

                for(int v:adj.get(u)){
                    if(dis[v]==-1){
                        dis[v]=dis[u]+1;
                        par[v]=u;
                        q.offer(v);
                    }
                    else if(par[u]!=v){
                        minCycleDistance=Math.min(minCycleDistance,dis[u]+dis[v]+1);
                    }
                }
            }
        }
        return minCycleDistance==Integer.MAX_VALUE?-1:minCycleDistance;
    }
}