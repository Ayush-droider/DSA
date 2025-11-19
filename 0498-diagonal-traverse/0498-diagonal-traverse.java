class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int key=i+j;
                if(!map.containsKey(key)){
                    map.put(key,new ArrayList<>());
                }
                map.get(key).add(mat[i][j]);
            }
        }
        boolean flag=true;
        List<Integer> result=new ArrayList<>();
        for(List<Integer> list:map.values()){
            if(flag){
                Collections.reverse(list);
            }
            for(int num:list){
                result.add(num);
            }
            flag=!flag;
        }
        int[] ans=new int[result.size()];
        for(int i=0;i<result.size();i++){
            ans[i]=result.get(i);
        }
        return ans;
    }
}