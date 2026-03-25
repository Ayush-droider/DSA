class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        long totalSum=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                totalSum+=grid[i][j];
            }
        }
        
        if(totalSum%2!=0)return false;

        long prefix=0;
        for(int i=0;i<n-1;i++){
            for(int j=0;j<m;j++){
                prefix+=grid[i][j];
            }
            if((totalSum-prefix)==prefix)return true;
        }

        prefix=0;
        for(int j=0;j<m-1;j++){
            for(int i=0;i<n;i++){
                prefix+=grid[i][j];
            }
            if((totalSum-prefix)==prefix)return true;
        }

        return false;
    }
}