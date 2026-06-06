class Solution {
    void swap(int start,int end,int[] arr){
        int temp=arr[start];
        arr[start]=arr[end];
        arr[end]=temp;
    }
    void segregate0and1(int[] arr) {
        // code here
        int i=0;
        for(int j=0;j<arr.length;j++){
            if(arr[j]==0){
                swap(i,j,arr);
                i++;
            }
        }
    }
}
