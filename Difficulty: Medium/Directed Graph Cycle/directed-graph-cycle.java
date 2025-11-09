class Solution {
    private boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] vis, int[] pathvis) {
        vis[node] = 1;
        pathvis[node] = 1;
        for (int it : adj.get(node)) {
            if (vis[it] == 0) {
                if (dfs(it, adj, vis, pathvis)) 
                    return true;
            } 
            else if (pathvis[it] == 1) {
                return true;
            }
        }
        pathvis[node] = 0; 
        return false;
    }
    public boolean isCyclic(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
        }
        int[] vis = new int[V];
        int[] pathvis = new int[V];
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                if (dfs(i, adj, vis, pathvis)) {
                    return true;
                }
            }
        }
        return false; 
    }
}
