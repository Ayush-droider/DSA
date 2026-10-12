class Solution {
    public int countAsterisks(String s) {
        int n=s.length(),count=0;
        boolean isInside=true;
        for(char ch:s.toCharArray()){
            if(ch=='|')isInside=!isInside;
            else if(isInside && ch=='*')count++;
        }
        return count;
    }
}