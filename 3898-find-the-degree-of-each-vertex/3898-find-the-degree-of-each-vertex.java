class Solution {
    public int[] findDegrees(int[][] matrix) {
        int vertices=matrix.length;
        int[] ans=new int[vertices];
        for(int i=0;i<vertices;i++){
            for(int j=0;j<vertices;j++){
                if(matrix[i][j]==1)ans[i]++;
            }
        }
        return ans;
    }
}