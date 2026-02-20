class Solution {
    boolean isPossible(int node,int m,List<List<Integer>> graph,int[] vis){
        for(int it:graph.get(node)){
            if(vis[it]==m)return false;
        }
        return true;
    }
    boolean solve(int node,int v,List<List<Integer>> graph,int m,int[] vis){
    
        if(node==v){
            return true;
        }
        
        for(int i=1;i<=m;i++){
            if(isPossible(node,i,graph,vis)){
                vis[node]=i;
                if(solve(node+1,v,graph,m,vis)) return true;
                vis[node]=0;
            }
        }
        return false;
    }
    boolean graphColoring(int v, int[][] edges, int m) {
        // code here
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<v;i++){
            graph.add(new ArrayList<>());
        }
        
        int[] vis=new int[v];
        
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int x=edges[i][1];
            
            graph.get(u).add(x);
            graph.get(x).add(u);
        }
        boolean ans=solve(0,v,graph,m,vis);
        return ans;
    }
}