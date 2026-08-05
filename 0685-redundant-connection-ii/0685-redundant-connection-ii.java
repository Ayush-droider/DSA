class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n=edges.length;
        for(int skip=n-1;skip>=0;skip--){
            List<List<Integer>> adj=new ArrayList<>();
            for(int i=0;i<=n;i++){
                adj.add(new ArrayList<>());
            }
            int[] indegree=new int[n+1];
            for(int i=0;i<n;i++){
                if(i==skip)continue;
                int u=edges[i][0];
                int v=edges[i][1];
                adj.get(u).add(v);
                indegree[v]++;
            }
            int root=-1;
            int roots=0;
            for(int i=1;i<=n;i++){
                if(indegree[i]==0){
                    root=i;
                    roots++;
                }
            }
            if(roots!=1)continue;
            boolean[] vis = new boolean[n + 1];
            dfs(root,adj,vis);
            boolean ok=true;
            for(int i=1;i<=n;i++){
                if(!vis[i]){
                    ok=false;
                    break;
                }
            }
            if(ok){
                return edges[skip];
            }
        }
        return new int[0];
    }

    private void dfs(int node, List<List<Integer>> adj, boolean[] vis){
        vis[node]=true;
        for(int nei:adj.get(node)){
            if(!vis[nei]){
                dfs(nei,adj,vis);
            }
        }
    }
}