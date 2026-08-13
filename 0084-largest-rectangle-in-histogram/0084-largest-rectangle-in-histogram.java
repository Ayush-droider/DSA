class Solution {
    private int[] findNSE(int[] heights){
        int[] nse=new int[heights.length];
        Stack<Integer> st=new Stack<>();
        for(int i=heights.length-1;i>=0;i--){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            nse[i]=(st.isEmpty())?heights.length:st.peek();
            st.push(i);
        }
        return nse;
    }
    private int[] findPSE(int[] heights){
        Stack<Integer> st=new Stack<>();
        int[] pse=new int[heights.length];
        for(int i=0;i<heights.length;i++){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            pse[i]=(st.isEmpty())?-1:st.peek();
            st.push(i);
        }
        return pse;
    }
    public int largestRectangleArea(int[] heights) {
        int[] nse=findNSE(heights);
        int[] pse=findPSE(heights);
        int maxArea=0;
        for(int i=0;i<heights.length;i++){
            maxArea=Math.max(maxArea,heights[i]*(nse[i]-pse[i]-1));
        }
        return maxArea;
    }
}