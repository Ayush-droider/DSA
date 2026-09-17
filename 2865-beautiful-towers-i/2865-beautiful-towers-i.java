class Solution {
    public long maximumSumOfHeights(int[] heights) {
        long ans=0;
        for(int maxIndex=0;maxIndex<heights.length;maxIndex++){
            long sum=heights[maxIndex];
            int min=heights[maxIndex];
            for(int i=maxIndex-1;i>=0;i--){
                min=Math.min(min,heights[i]);
                sum+=min;
            }
            min=heights[maxIndex];
            for(int i=maxIndex+1;i<heights.length;i++){
                min=Math.min(min,heights[i]);
                sum+=min;
            }
            ans=Math.max(ans,sum);
        }
        return ans;
    }
}