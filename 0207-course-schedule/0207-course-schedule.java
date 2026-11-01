class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj=new ArrayList<>();
        int[] indegree=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] p:prerequisites){
            int u=p[0];
            int v=p[1];

            adj.get(u).add(v);
            indegree[v]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0)q.add(i);
        }
        int count=0;
        while(!q.isEmpty()){
            int node=q.poll();
            count++;
            for(int neigh:adj.get(node)){
                indegree[neigh]--;
                if(indegree[neigh]==0)q.add(neigh);
            }
        }
        return count==numCourses;
    }
}