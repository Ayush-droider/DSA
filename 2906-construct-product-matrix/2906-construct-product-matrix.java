class Solution {
    static int mod=12345;
    public int[][] constructProductMatrix(int[][] grid) {
        long p=1,s=1;
        int n=grid.length;
        int m=grid[0].length;
        int[][] ans=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                ans[i][j]=(int)p;
                p=(p*grid[i][j])%mod;
            }
        }
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                ans[i][j]=(int)(s*ans[i][j])%mod;
                s=(s*grid[i][j])%mod;
            }
        }
        return ans;
    }
}