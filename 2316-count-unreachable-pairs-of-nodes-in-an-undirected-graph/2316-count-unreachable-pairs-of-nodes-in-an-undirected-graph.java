class Solution {
    long[] parent;
    long[] rank;

    private long find(long a){
        if(a==parent[(int)a])return a;
        return parent[(int)a]=find(parent[(int)a]);
    }

    private void Union(long a,long b){
        long a_parent=find(a);
        long b_parent=find(b);

        if(a_parent==b_parent)return;

        if(rank[(int)a_parent]>rank[(int)b_parent]){
            parent[(int)b_parent]=a_parent;
        }
        else if(rank[(int)a_parent]<rank[(int)b_parent]){
            parent[(int)a_parent]=b_parent;
        }
        else{
            parent[(int)b_parent]=a_parent;
            rank[(int)a_parent]++;
        }
    }

    public long countPairs(int n, int[][] edges) {
        rank=new long[n];
        parent=new long[n];

        for(long i=0;i<n;i++){
            parent[(int)i]=i;
        }

        for(int[] e:edges){
            int u=e[0];
            int v=e[1];

            long u_parent=find(u);
            long v_parent=find(v);

            if(u_parent!=v_parent){
                Union(u,v);
            }
        }

        Map<Long,Long> map=new HashMap<>();

        for(int i=0;i<n;i++){
            long papa=find(i);
            map.put(papa,map.getOrDefault(papa,0L)+1);
        }

        long unreachableNodes=0;
        long remainingNodes=n;

        for(long a:map.values()){
            unreachableNodes+=a*(remainingNodes-a);
            remainingNodes-=a;
        }

        return unreachableNodes;
    }
}