class Solution {
    public int[] shortestPath(int V, int[][] edges, int src) {
        // code here
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<V;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] e:edges){
            int u=e[0];
            int v=e[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        int[] dis=new int[V];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[src]=0;
        int[] res=new int[V];
        Arrays.fill(res,-1);
        Queue<Integer> q=new LinkedList<>();
        q.add(src);
        while(!q.isEmpty()){
            int node=q.poll();
            for(int neigh:graph.get(node)){
                if(dis[node]+1<dis[neigh]){
                    dis[neigh]=dis[node]+1;
                    q.add(neigh);
                }
            }
        }
        for(int i=0;i<V;i++){
            if(dis[i]==Integer.MAX_VALUE){
                res[i]=-1;
            }
            else res[i]=dis[i];
        }
        return res;
    }
}
