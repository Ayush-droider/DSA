class Solution {
    public int getSecondLargest(int[] arr) {
        // code here
        int largest=Integer.MIN_VALUE;
        int seclargest=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>largest){
                seclargest=largest;
                largest=arr[i];
            }
            else if(arr[i]<largest && arr[i]>seclargest){
                seclargest=arr[i];
            }
        }
        return seclargest == Integer.MIN_VALUE ? -1 : seclargest;
    }
}