class Solution {
    
    private void dfs(int node,boolean[] vis,List<List<Integer>> adj){
        vis[node]=true;
        for(int neigh:adj.get(node)){
            if(!vis[neigh]){
                dfs(neigh,vis,adj);
            }
        }
    }
    
    int countConnected(int V, ArrayList<ArrayList<Integer>> edges) {
        // code here
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        
        for(List<Integer> l:edges){
            adj.get(l.get(0)).add(l.get(1));
            adj.get(l.get(1)).add(l.get(0));
        }
        
        int count=0;
        boolean[] vis=new boolean[V];
        
        for(int i=0;i<V;i++){
            if(!vis[i]){
                count++;
                dfs(i,vis,adj);
            }
        }
        return count;
    }
}