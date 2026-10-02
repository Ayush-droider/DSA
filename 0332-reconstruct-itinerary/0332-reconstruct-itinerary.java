class Solution {
    private Map<String,PriorityQueue<String>> adj=new HashMap<>();
    private LinkedList<String> ans=new LinkedList<>();

    private void dfs(String node){
        PriorityQueue<String> pq=adj.get(node);
        while(pq!=null&&!pq.isEmpty()){
            dfs(pq.poll());
        }
        ans.addFirst(node);
    }

    public List<String> findItinerary(List<List<String>> tickets){
        for(List<String> list:tickets){
            String u=list.get(0);
            String v=list.get(1);
            adj.computeIfAbsent(u,k->new PriorityQueue<>()).add(v);
        }
        dfs("JFK");
        return ans;
    }
}