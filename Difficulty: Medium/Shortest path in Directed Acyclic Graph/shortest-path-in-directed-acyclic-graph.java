// User function Template for Java
class Solution {
    private class Pair{
        int first;
        int second;
        Pair(int first,int second){
            this.first=first;
            this.second=second;
        }
    }
    
    public void topo(int node,int[] vis,Stack<Integer> st,ArrayList<ArrayList<Pair>> adj){
        vis[node]=1;
        for(int i=0;i<adj.get(node).size();i++){
            int v=adj.get(node).get(i).first;
            if(vis[v]==0) topo(v,vis,st,adj);
        }
        st.push(node);
    }

    public int[] shortestPath(int V, int E, int[][] edges) {

        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            ArrayList<Pair> temp=new ArrayList<>();
            adj.add(temp);
        }

        for(int i=0;i<E;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            int wt=edges[i][2];
            adj.get(u).add(new Pair(v,wt));
        }

        int[] vis=new int[V];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<V;i++){
            if(vis[i]==0) topo(i,vis,st,adj);
        }
        int[] dis=new int[V];
        for(int i=0;i<V;i++){
            dis[i]=(int)(1e9);
        }
        dis[0]=0;
        while(!st.isEmpty()){
            int node=st.pop();
            for(int i=0;i<adj.get(node).size();i++){
                int v=adj.get(node).get(i).first;
                int wt=adj.get(node).get(i).second;
                if(dis[node] != (int)1e9 && dis[node]+wt < dis[v]){
                    dis[v] = dis[node] + wt;
                }
            }
        }
        for (int i = 0; i < V; i++) {
            if (dis[i] == (int)1e9) dis[i] = -1;
        }

        return dis;
    }
}
