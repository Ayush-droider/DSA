class Solution{
    int[][] ans;
    int value=1;
    private void makeSpiral(int top,int bottom,int left,int right,int dir){
        if(top>bottom||left>right)return;
        if(dir==0){
            for(int i=left;i<=right;i++)ans[top][i]=value++;
            makeSpiral(top+1,bottom,left,right,1);
        }else if(dir==1){
            for(int i=top;i<=bottom;i++)ans[i][right]=value++;
            makeSpiral(top,bottom,left,right-1,2);
        }else if(dir==2){
            for(int i=right;i>=left;i--)ans[bottom][i]=value++;
            makeSpiral(top,bottom-1,left,right,3);
        }else{
            for(int i=bottom;i>=top;i--)ans[i][left]=value++;
            makeSpiral(top,bottom,left+1,right,0);
        }
    }
    public int[][] generateMatrix(int n){
        ans=new int[n][n];
        value=1;
        makeSpiral(0,n-1,0,n-1,0);
        return ans;
    }
}