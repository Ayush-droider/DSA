class Solution {
    public void dfs(int node,boolean[] vis,Stack<Integer> st,List<List<Integer>> graph){
        vis[node]=true;
        for(int neigh:graph.get(node)){
            if(!vis[neigh]){
                dfs(neigh,vis,st,graph);
            }
        }
        st.push(node);
    }
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        boolean[] vis=new boolean[V];
        Stack<Integer> st=new Stack<>();
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<V;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            graph.get(u).add(v);
        }
        for(int i=0;i<V;i++){
            if(!vis[i]){
                dfs(i,vis,st,graph);
            }
        }
        ArrayList<Integer> ans=new ArrayList<>();
        while(!st.isEmpty()){
            ans.add(st.pop());
        }
        return ans;
    }
}