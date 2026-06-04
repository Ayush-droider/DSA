class Solution {
    public int minPartitions(String n) {
        int maxDigit=0;
        for(char ch:n.toCharArray()){
            maxDigit=Math.max(maxDigit,ch - '0');
        }
        return maxDigit;
    }
}