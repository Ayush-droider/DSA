class Solution {
    public int heightChecker(int[] heights) {
        int cnt=0;
        int[] expected=heights.clone();
        for(int i=0;i<heights.length;i++){
            for(int j=0;j<heights.length-i-1;j++){
                if(heights[j]>heights[j+1]){
                    int temp=heights[j];
                    heights[j]=heights[j+1];
                    heights[j+1]=temp;
                }
            }
        }
        for(int i=0;i<heights.length;i++){
            if(heights[i]!=expected[i])cnt++;
        }
        return cnt;
    }
}