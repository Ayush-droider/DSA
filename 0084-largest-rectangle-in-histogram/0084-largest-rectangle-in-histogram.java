class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        Stack<Integer> st=new Stack<>();
        int maxArea=0;
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                int h=heights[st.pop()];
                int right=i;
                int left=(st.isEmpty())?-1:st.peek();
                int width=right-left-1;
                maxArea=Math.max(maxArea,width*h);
            }
            st.push(i);
        }
        while (!st.isEmpty()) {
            int h = heights[st.pop()];
            int right = n;
            int left = st.isEmpty() ? -1 : st.peek();
            int width = right - left - 1;
            maxArea = Math.max(maxArea, width * h);
        }
        
        return maxArea;
    }
}