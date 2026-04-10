class Solution {
    private void swap(int start,int end,int[] arr){
        int temp=arr[start];
        arr[start]=arr[end];
        arr[end]=temp;
    }
    public void sort012(int[] arr) {
        // code here
        int n=arr.length;
        int i=0,j=0,k=n-1;
        
        while(j<=k){
            if(arr[j]==0){
                swap(i,j,arr);
                i++;
                j++;
            }
            else if(arr[j]==2){
                swap(j,k,arr);
                k--;
            }
            else j++;
        }
    }
}