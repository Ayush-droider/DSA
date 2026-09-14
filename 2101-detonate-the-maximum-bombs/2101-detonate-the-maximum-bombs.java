class Solution {
    private int dfs(int node,boolean[] vis,List<List<Integer>> graph){
        vis[node]=true;
        int count=1;
        for(int neigh:graph.get(node)){
            if(!vis[neigh]){
                count+=dfs(neigh,vis,graph);
            }
        }
        return count;
    }
    public int maximumDetonation(int[][] bombs) {
        int n=bombs.length;
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            int x1=bombs[i][0];
            int y1=bombs[i][1];
            int r=bombs[i][2];
            for(int j=0;j<n;j++){
                int x2=bombs[j][0];
                int y2=bombs[j][1];

                long a=x1-x2;
                long b=y1-y2;

                if((a*a+b*b)<=(long) r*r){
                    graph.get(i).add(j);
                }
            }
        }

        int ans=0;
        
        for(int i=0;i<n;i++){
            boolean[] vis=new boolean[n];
            int count=dfs(i,vis,graph);
            ans=Math.max(ans,count);
            
        }
        return ans;
    }
}