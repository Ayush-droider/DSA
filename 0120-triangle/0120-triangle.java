class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        Integer[][] dp=new Integer[201][201];
        return helper(0,0,triangle,n,dp);
    }
    private int helper(int row,int col,List<List<Integer>> triangle,int n,Integer[][] dp){

        if(row==n-1){
            return triangle.get(row).get(col);
        }

        if(dp[row][col]!=null)return dp[row][col];

        int same=helper(row+1,col,triangle,n,dp);
        int samePlusOne=helper(row+1,col+1,triangle,n,dp);

        return dp[row][col]=triangle.get(row).get(col)+Math.min(same,samePlusOne);
    }
}