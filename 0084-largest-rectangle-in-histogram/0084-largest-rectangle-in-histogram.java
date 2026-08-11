class Solution {
    private class Pair{
        int height;
        int pos;
        Pair(int height,int pos){
            this.height=height;
            this.pos=pos;
        }
    }
    public int largestRectangleArea(int[] heights) {
        Stack<Pair> st=new Stack<>();
        int maxi=Integer.MIN_VALUE;
        int start=0;
        for(int i=0;i<heights.length;i++){
            start=i;
            while(!st.isEmpty() && st.peek().height>heights[i]){
                Pair p=st.pop();
                int area=p.height*(i-p.pos);
                maxi=Math.max(maxi,area);
                start=p.pos;
            }
            st.push(new Pair(heights[i],start));
        }
        while(!st.isEmpty()){
            Pair p=st.pop();
            int area=p.height*(heights.length-p.pos);
            maxi=Math.max(maxi,area);
        }
        return maxi;
    }
}