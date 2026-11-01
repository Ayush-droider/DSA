class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> safeList=new ArrayList<>();
        int n=graph.length;
        int m=graph[0].length;
        List<List<Integer>> adj=new ArrayList<>();
        int[] indegree=new int[n];

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++){
            for(int neigh:graph[i]){
                adj.get(neigh).add(i);
                indegree[i]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0)q.add(i);
        }
        while(!q.isEmpty()){
            int node=q.poll();
            safeList.add(node);
            for(int neigh:adj.get(node)){
                indegree[neigh]--;
                if(indegree[neigh]==0)q.add(neigh);
            }
        }
        Collections.sort(safeList,
            (a,b)->Integer.compare(a,b));
        return safeList;
    }
}