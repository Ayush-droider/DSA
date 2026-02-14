class Solution {
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        ArrayList<Integer> ans=new ArrayList<>();
        int V=adj.size();
        boolean[] vis=new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i])dfs(i,ans,vis,adj);
        }
        return ans;
    }
    public void dfs(int node,ArrayList<Integer> ans,boolean[] vis,ArrayList<ArrayList<Integer>> adj){
        vis[node]=true;
        ans.add(node);
        for(int it:adj.get(node)){
            if(!vis[it]){
                dfs(it,ans,vis,adj);
            }
        }
    }
}