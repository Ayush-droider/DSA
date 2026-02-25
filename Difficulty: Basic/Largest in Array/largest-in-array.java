class Solution {
    public static int largest(int[] arr) {
        // code here
        int maxi=0;
        for(int num:arr){
            maxi=Math.max(maxi,num);
        }
        return maxi;
    }
}
