class Solution {
    public long[] sumOfThree(long num) {
        long[] ans=new long[3];
        long l=-num-1,r=num;
        while(l<=r){
            long mid=l+(r-l)/2;
            long sum=mid+(mid+1)+(mid+2);
            if(sum==num){
                return new long[]{mid,mid+1,mid+2};
            }
            else if(sum>num){
                r=mid-1;
            }
            else l=mid+1;
        }
        return new long[]{};
    }
}