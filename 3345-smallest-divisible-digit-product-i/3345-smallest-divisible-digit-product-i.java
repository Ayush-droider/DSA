class Solution {
    private int POD(int num){
        int r=0,sum=1;
        while(num!=0){
            r=num%10;
            sum*=r;
            num=num/10;
        }
        return sum;
    }
    public int smallestNumber(int n, int t) {
        for(int i=n;i<101;i++){
            if(POD(i)%t==0)return i;
        }
        return -1;
    }
}