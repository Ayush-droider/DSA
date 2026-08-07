class Solution {
    //2- min me aukat dikhata teri main ga**nd maar lunga
    private int[] getRightMax(int[] height){
        int[] right=new int[height.length];
        right[right.length-1]=height[height.length-1];
        for(int i=right.length-2;i>=0;i--){
            right[i]=Math.max(height[i],right[i+1]);
        }
        return right;
    }
    private int[] getLeftMax(int[] height){
        int[] left=new int[height.length];
        left[0]=height[0];
        for(int i=1;i<height.length;i++){
            left[i]=Math.max(height[i],left[i-1]);
        }
        return left;
    }
    public int trap(int[] height) {
        int[] rightmax=getRightMax(height);
        int[] leftmax=getLeftMax(height);
        int sum=0;
        for(int i=0;i<height.length;i++){
            sum+=Math.min(rightmax[i],leftmax[i])-height[i];
        }
        return sum;
    }
}