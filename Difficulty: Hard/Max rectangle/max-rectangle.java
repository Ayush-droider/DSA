class Solution {
    static int maxArea(int mat[][]) {
        // code here
        int row=mat.length;
        int col=mat[0].length;
        int maxArea=Integer.MIN_VALUE;
        int[] height=new int[col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(mat[i][j]==1)height[j]+=1;
                else height[j]=0;
            }
            maxArea=Math.max(maxArea,largestRectangle(height));
        }
        return maxArea;
    }
    private static int largestRectangle(int[] height){
        int n=height.length;
        Stack<Integer> st=new Stack<>();
        int maxArea=Integer.MIN_VALUE;
        for(int i=0;i<=n;i++){
            int curr=(i==n)?0:height[i];
            while(!st.isEmpty() && height[st.peek()]>=curr){
                int h=height[st.pop()];
                int right=i;
                int left=(st.isEmpty())?-1:st.peek();
                int width=right-left-1;
                maxArea=Math.max(maxArea,width*h);
            }
            st.push(i);
        }
        return maxArea;
    }
}