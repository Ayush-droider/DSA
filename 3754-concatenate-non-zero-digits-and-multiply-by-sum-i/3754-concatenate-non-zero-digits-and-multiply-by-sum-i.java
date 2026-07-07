class Solution {
    private int getSum(int n){
        int r=0,sum=0;
        while(n!=0){
            r=n%10;
            sum+=r;
            n=n/10;
        }
        return sum;
    }
    public long sumAndMultiply(int n) {
        String s=String.valueOf(n);
        StringBuilder sb=new StringBuilder();
        for(char ch:s.toCharArray()){
            if(ch!='0')sb.append(ch);
        }
        if(sb.length()==0)return 0;
        int a=Integer.parseInt(sb.toString());
        int sum=getSum(a);
        return (long)a*sum;
    }
}