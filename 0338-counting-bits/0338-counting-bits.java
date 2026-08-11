class Solution {
    public int[] countBits(int n) {
       int[] ans=new int[n+1];
       for(int i=0;i<=n;i++){
        int count=0;
        int p=i;
        while(p!=0){
            count+=p%2;
            p/=2;
        }
        ans[i]=count;
       }
       return ans;
    }
}