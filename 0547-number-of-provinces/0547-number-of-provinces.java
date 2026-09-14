class Solution {
    private void bfs(int node,boolean[] vis,List<List<Integer>> adj){
        Queue<Integer> q=new LinkedList<>();
        q.add(node);
        vis[node]=true;
        while(!q.isEmpty()){
            int curr=q.poll();

            for(int neigh:adj.get(curr)){
                if(!vis[neigh]){
                    q.add(neigh);
                    vis[neigh]=true;
                }
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        int m=isConnected[0].length;

        List<List<Integer>> adj=new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(isConnected[i][j]==1){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        int count=0;

        boolean[] vis=new boolean[n+1];
        for(int i=0;i<n;i++){
            if(!vis[i]){
                count++;
                bfs(i,vis,adj);
            }
        }
        return count;
    }
}