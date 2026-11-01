class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> safeList=new ArrayList<>();

        List<List<Integer>> adj=new ArrayList<>();
        int[] indegree=new int[numCourses];

        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] p:prerequisites){
            int u=p[0];
            int v=p[1];
            adj.get(v).add(u);
            indegree[u]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
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
        if(safeList.size()!=numCourses){
            return new int[0];
        }
        int[] arr=new int[safeList.size()];
        for(int i=0;i<safeList.size();i++){
            arr[i]=safeList.get(i);
        }
        return arr;
    }
}