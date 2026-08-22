class Solution {
    private int getSOD(int n){
        int r=0,sum=0;
        while(n!=0){
            r=n%10;
            sum+=r;
            n=n/10;
        }
        return sum;
    }
    private int getPOD(int n){
        int r=0,sum=1;
        while(n!=0){
            r=n%10;
            sum*=r;
            n=n/10;
        }
        return sum;
    }
    public boolean checkDivisibility(int n) {
       int sum=getSOD(n);
       int prod=getPOD(n);
        return n%(sum+prod)==0;
    }
}