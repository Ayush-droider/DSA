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
    public boolean equationsPossible(String[] equations) {
       int[] parent=new int[26];
       for(int i=0;i<26;i++){
        parent[i]=i;
       }
       rank=new int[26];
       for(String s:equations){
        if(s.charAt(1)=='='){
            Union(s.charAt(0)-'a',s.charAt(3)-'a',parent);
        }
       }
       for(String s:equations){
        if(s.charAt(1)=='!'){
            int parentx=find(s.charAt(0)-'a',parent);
            int parenty=find(s.charAt(3)-'a',parent);

            if(parentx==parenty)return false;
        }
       }
       return true;
    }
}