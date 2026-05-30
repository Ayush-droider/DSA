class Solution {
    public int[] diStringMatch(String s) {
        int I=0,D=s.length();
        int[] result=new int[s.length()+1];
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='I')result[i]=I++;
            else result[i]=D--;
        }
        result[s.length()]=D;
        return result;
    }
}