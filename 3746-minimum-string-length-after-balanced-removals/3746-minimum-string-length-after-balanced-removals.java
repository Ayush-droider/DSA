class Solution {
    public int CountA(String s){
        int a=0;
        for(char ch:s.toCharArray()){
            if(ch=='a')a++;
        }
        return a;
    }
    public int CountB(String s){
        int b=0;
        for(char ch:s.toCharArray()){
            if(ch=='b')b++;
        }
        return b;
    }
    public int minLengthAfterRemovals(String s) {
        int a=CountA(s);
        int b=CountB(s);
        return Math.abs(a-b);   
    }
}