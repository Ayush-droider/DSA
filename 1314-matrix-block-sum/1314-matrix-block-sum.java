class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m=mat.length;
        int n=mat[0].length;
        for(int i=0;i<m;i++){
            int sum=0;
            for(int j=0;j<n;j++){
                sum+=mat[i][j];
                mat[i][j]=sum;
            }
        }
        for(int j=0;j<n;j++){
            int sum=0;
            for(int i=0;i<m;i++){
                sum+=mat[i][j];
                mat[i][j]=sum;
            }
        }

        //prefix sum added

        int[][] ans=new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int x=Math.min(m-1,i+k),y=Math.min(n-1,j+k),sum=0;

                sum+=mat[x][y];

                if(j-k-1>-1) sum-=mat[x][j-k-1];  // left hata
                if(i-k-1>-1) sum-=mat[i-k-1][y];  // top hata
                if(i-k-1>-1 && j-k-1>-1) sum+=mat[i-k-1][j-k-1]; //top left do baar hata to ek baar add kar

                ans[i][j]=sum;
            }
        }
        return ans;
    }
}