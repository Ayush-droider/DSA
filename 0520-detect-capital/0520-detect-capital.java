class Solution {
    public boolean detectCapitalUse(String word) {
        int capital=0;
        for(char ch:word.toCharArray()){
            if(Character.isUpperCase(ch))capital++;
        }
        return capital==0 || (capital==1 && Character.isUpperCase(word.charAt(0))) || capital==word.length();
    }
}