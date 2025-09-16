class Solution {
    public int getSecondLargest(int[] arr) {
        int largest=arr[0],slargest=-1;
        for(int i=1;i<arr.length;i++){
            if(arr[i]>largest){
                slargest=largest;
                largest=arr[i];
            }
            else if(arr[i]<largest && arr[i]>slargest){
                slargest=arr[i];
            }
        }
        return slargest;
    }
}