class Solution {
    private class Pair{
        int first;
        int second;
        Pair(int first,int second){
            this.first=first;
            this.second=second;
        }
    }
    private class Tuple{
        int stop;
        int node;
        int cost;
        Tuple(int stop,int node,int cost){
            this.stop=stop;
            this.node=node;
            this.cost=cost;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] f:flights){
            int u=f[0];
            int v=f[1];
            int c=f[2];
            graph.get(u).add(new Pair(v,c));
        }
        int[] dis=new int[n];
        Arrays.fill(dis,(int)1e9);
        dis[src]=0;

        Queue<Tuple> pq=new LinkedList<>();
        pq.offer(new Tuple(0,src,0));
        while(!pq.isEmpty()){
            Tuple p=pq.poll();
            int st=p.stop;
            int nod=p.node;
            int cst=p.cost;

            if(st>k)continue;

            for(Pair neigh:graph.get(nod)){
                int edgeWt=neigh.second;
                int nde=neigh.first;

                if(cst+edgeWt<dis[nde] && st<=k){
                    dis[nde]=cst+edgeWt;
                    pq.add(new Tuple(st+1,nde,dis[nde]));
                }
            }
        }
        if(dis[dst]==(int)(1e9))return -1;
        else return dis[dst];
    }
}