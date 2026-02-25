class Solution {
    void pushZerosToEnd(int[] arr) {
        // code here
        int count=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=0)arr[count++]=arr[i];
        }
        int zeros=arr.length-count;
        while(zeros!=0){
            arr[count++]=0;
            zeros--;
        }
    }
}