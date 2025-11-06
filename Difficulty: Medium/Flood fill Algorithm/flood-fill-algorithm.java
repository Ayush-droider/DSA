class Solution {
    public void dfs(int row,int col,int[][] ans,int[][] image,int initialColor,int newColor,int[] delrow,int[] delcol){
        ans[row][col]=newColor;
        int n=image.length;
        int m=image[0].length;
        for(int i=0;i<4;i++){
            int nrow=row+delrow[i];
            int ncol=col+delcol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && image[nrow][ncol]==initialColor && ans[nrow][ncol]!=newColor){
                ans[nrow][ncol]=newColor;
                dfs(nrow,ncol,ans,image,initialColor,newColor,delrow,delcol);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int initialColor=image[sr][sc];
        int[][] ans=image;
        int[] delrow={-1,0,1,0};
        int[] delcol={0,1,0,-1};
        dfs(sr,sc,ans,image,initialColor,newColor,delrow,delcol);
        return ans;
    }
}