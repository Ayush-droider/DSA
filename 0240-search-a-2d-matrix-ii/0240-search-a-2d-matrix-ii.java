class Solution {
    private boolean binarySearch(int[] mat,int target){
        int l=0,r=mat.length-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(mat[mid]==target)return true;
            else if(mat[mid]>target){
                r=mid-1;
            }
            else l=mid+1;
        }
        return false;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int[] row:matrix){
            boolean ans=binarySearch(row,target);
            if(ans){
                return true;
            }
        }
        return false;
    }
}