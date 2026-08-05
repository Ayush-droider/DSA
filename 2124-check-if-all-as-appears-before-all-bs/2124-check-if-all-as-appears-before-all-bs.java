class Solution {
    public boolean checkString(String s) {
        for(int i=1;i<s.length();i++){
            char curr=s.charAt(i);
            char last=s.charAt(i-1);
            if(curr=='a' && last=='b')return false;
        }
        return true;
    }
}