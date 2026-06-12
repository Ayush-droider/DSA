class Solution {
    public String thousandSeparator(int n) {
        String str=String.valueOf(n);
        StringBuilder sb=new StringBuilder(str);
        for (int i=sb.length()-3;i>0;i-=3){
            sb.insert(i,".");
        }
        return sb.toString();
    }
}