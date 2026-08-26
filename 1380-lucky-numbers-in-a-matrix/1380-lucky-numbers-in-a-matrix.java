class Solution {
    private boolean isLucky(int num,int[][] mat,int x,int y){
        for(int j=0; j<mat[0].length;j++){
            if(mat[x][j]<num){
                return false;
            }
        }
        for(int i=0; i<mat.length;i++){
            if(mat[i][y]>num){
                return false;
            }
        }
        return true;
    }
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> list=new ArrayList<>();
        int n=matrix.length;
        int m=matrix[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(isLucky(matrix[i][j],matrix,i,j)){
                    list.add(matrix[i][j]);
                }
            }
        }
        return list;
    }
}