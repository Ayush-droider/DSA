class Solution {
    public boolean validMountainArray(int[] arr) {
        int n=arr.length;
        boolean[] prefix=new boolean[n];
        boolean[] suffix=new boolean[n];

        prefix[0]=true;
        for(int i=1;i<n;i++){
            if(prefix[i-1] && arr[i]>arr[i-1]){
                prefix[i]=true;
            }
        }

        suffix[n-1]=true;
        for(int i=n-2;i>=0;i--){
            if(suffix[i+1] && arr[i]>arr[i+1]){
                suffix[i]=true;
            }
        }

        for(int i=1;i<n-1;i++){
            if(prefix[i] && suffix[i]){
                return true;
            }
        }

        return false;
    }
}