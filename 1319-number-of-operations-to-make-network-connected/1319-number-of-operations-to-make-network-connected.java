class Solution {
    int[] rank;
    private int find(int a,int[] parent){
        if(a==parent[a])return a;
        return parent[a]=find(parent[a],parent);
    }
    private void Union(int a,int b,int[] parent){
        int a_parent=find(a,parent);
        int b_parent=find(b,parent);
        
        if(a_parent==b_parent)return;
        
        if(rank[a_parent]>rank[b_parent]){
            parent[b_parent]=a_parent;
        }
        else if(rank[a_parent]<rank[b_parent]){
            parent[a_parent]=b_parent;
        }
        else{
            parent[a_parent]=b_parent;
            rank[b_parent]++;
        }
    }
    public int makeConnected(int n, int[][] connections) {
        int[] parent=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        rank=new int[n];
        if(connections.length<n-1)return -1;
        for(int[] c:connections){
            int u=c[0];
            int v=c[1];

            int uparent=find(u,parent);
            int vparent=find(v,parent);

            if(uparent!=vparent){
                Union(uparent,vparent,parent);
            }
        }
        int component=0;
        for(int i=0;i<n;i++){
            if(find(i,parent)==i)component++;
        }
        return component-1;
    }
}