class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int key=i-j;
                if(!map.containsKey(key)){
                    map.put(key,new ArrayList<>());
                }
                map.get(key).add(mat[i][j]);
            }
        }
        for(List<Integer> diag:map.values()){
            Collections.sort(diag);
        }
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                int key=i-j;
                List<Integer> list=map.get(key);
                mat[i][j]=list.remove(list.size()-1);
            }
        }
        return mat;
    }
}