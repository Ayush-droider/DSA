class Solution {
    int[] freq=new int[501];
    public int findLucky(int[] arr) {
        for(int a:arr){
            freq[a]++;
        }
        int ans=0;
        for(int i=1;i<501;i++){
            if(freq[i]==i)ans=i;
        }
        return ans==0?-1:ans;
    }
}