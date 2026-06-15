class Solution {
    private int[] getLeftMax(int[] height){
        int[] left=new int[height.length];
        left[0]=height[0];
        for(int i=1;i<height.length;i++){
            left[i]=Math.max(left[i-1],height[i]);
        }
        return left;
    }

    private int[] getRightMax(int[] height){
        int[] right=new int[height.length];
        right[height.length-1]=height[height.length-1];
        for(int i=height.length-2;i>=0;i--){
            right[i]=Math.max(right[i+1],height[i]);
        }
        return right;
    }

    public int trap(int[] height) {
        int[] leftmax=getLeftMax(height);
        int[] rightmax=getRightMax(height);

        int sum=0;
        for(int i=0;i<height.length;i++){
            sum+=Math.min(leftmax[i],rightmax[i])-height[i];
        }
        
        return sum;
    }
}