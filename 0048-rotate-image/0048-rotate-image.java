class Solution {
    public void reverse(int[] row,int start,int end){
        while(start<end){
            int temp=row[start];
            row[start]=row[end];
            row[end]=temp;
            start++;
            end--;
        }
    }
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;

        for(int i=0;i<n;i++){
            for(int j=i+1;j<m;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }

        for(int[] row:matrix){
            reverse(row,0,row.length-1);
        }
    }
}