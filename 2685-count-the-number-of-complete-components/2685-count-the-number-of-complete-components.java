class Solution {
    int countNodes;//to count edge
    int countEdge;
    private void dfs(int node,boolean[] vis,List<List<Integer>> adj){
        vis[node]=true;
        countNodes++;
        countEdge+=adj.get(node).size();
        for(int neigh:adj.get(node)){
            if(!vis[neigh]){
                dfs(neigh,vis,adj);
            }
        }
    }
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e:edges){
            int u=e[0];
            int v=e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int ans=0;
        boolean[] vis=new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i]){
                countNodes=0;
                countEdge=0;
                dfs(i,vis,adj);
                countEdge/=2;
                if(countEdge==countNodes*(countNodes-1)/2)ans++;
            }
        }
        return ans;
    }
}