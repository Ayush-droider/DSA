class Solution {
    private class Pair{
        int node;
        int par;
        
        Pair(int node,int par){
            this.node=node;
            this.par=par;
        }
    }
    private boolean checkCycle(int node,int V,List<List<Integer>> adj,boolean[] vis){
        vis[node]=true;
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(node,-1));
        while(!q.isEmpty()){
            int nod=q.peek().node;
            int parent=q.peek().par;
            q.remove();
            
            for(int neigh:adj.get(nod)){
                if(!vis[neigh]){
                    vis[neigh]=true;
                    q.add(new Pair(neigh,nod));
                }
                else if(parent!=neigh)return true;
            }
        }
        return false;
    }
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e:edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        
        boolean[] vis=new boolean[V];
        
        for(int i=0;i<V;i++){
            if(!vis[i]){
                if(checkCycle(i,V,adj,vis))return true;
            }
        }
        return false;
    }
}