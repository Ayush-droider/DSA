class Solution {
    public int maxDepth(String s) {
        int leftBracket=0,rightBracket=0;
        int maxi=0;
        for(char ch:s.toCharArray()){
            if(ch=='('){
                leftBracket++;
                maxi=Math.max(maxi,leftBracket-rightBracket);
            }
            else if(ch==')')rightBracket++;
        }
        return maxi;
    }
}