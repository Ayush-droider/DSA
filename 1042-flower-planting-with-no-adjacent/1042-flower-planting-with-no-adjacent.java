class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] p : paths){
            int u = p[0]-1;
            int v = p[1]-1;
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int[] color=new int[n];
        for(int i=0; i<n; i++){
            boolean[] lechuka=new boolean[5];
            for(int neigh:adj.get(i)){
                if (color[neigh]!=0) {
                    lechuka[color[neigh]]=true;
                }
            }
            for(int c=1; c<=4; c++){
                if(!lechuka[c]){
                    color[i]=c;
                    break;
                }
            }
        }
        return color;
    }
}