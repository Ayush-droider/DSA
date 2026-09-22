class Solution {
    public int removePalindromeSub(String s) {
        StringBuilder sb=new StringBuilder(s);
        sb.reverse();
        return s.equals(sb.toString())?1:2;
    }
}