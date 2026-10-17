class Solution{
    public int edgeScore(int[] edges){
        int n=edges.length;
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            adj.get(edges[i]).add(i);
        }
        long[] indegree=new long[n];
        for(int i=0;i<n;i++){
            for(int node:adj.get(i)){
                indegree[i]+=node;
            }
        }
        int ans=0;
        for(int i=1;i<n;i++){
            if(indegree[i]>indegree[ans]){
                ans=i;
            }
        }
        return ans;
    }
}
