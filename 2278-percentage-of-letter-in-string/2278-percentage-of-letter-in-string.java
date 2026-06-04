class Solution {
    public int percentageLetter(String s, char letter) {
        int x=0;
        int len=s.length();
        for(char ch:s.toCharArray()){
            if(ch==letter)x++;
        }
        return (int)((x*100)/len);
    }
}