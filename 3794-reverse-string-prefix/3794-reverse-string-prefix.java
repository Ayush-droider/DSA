class Solution {
    public String reversePrefix(String s, int k) {
        String s1=s.substring(0,k);
        String s2=s.substring(k);
        StringBuilder sb=new StringBuilder(s1);
        sb.reverse();
        sb.append(s2);
        return sb.toString();
    }
}