class Solution {
    List<Integer> ans=new ArrayList<>();
    private void dfs(int node,boolean[] suspicious,List<List<Integer>> adj){
        suspicious[node]=true;
        for(int neigh:adj.get(node)){
            if(!suspicious[neigh]){
                dfs(neigh,suspicious,adj);
            }
        }
    }
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] in:invocations){
            int u=in[0];
            int v=in[1];
            adj.get(u).add(v);
        }
        boolean[] suspicious=new boolean[n];
        for(int i=0;i<n;i++){
            if(i==k){
                dfs(i,suspicious,adj);
            }
        }
        for(int[] in:invocations){
            int u=in[0];
            int v=in[1];
            if(!suspicious[u] && suspicious[v]){
                for(int i=0;i<n;i++){
                    ans.add(i);
                }
                return ans;
            }
        }
        for(int i=0;i<n;i++){
            if(!suspicious[i])ans.add(i);
        }
        return ans;
    }
}