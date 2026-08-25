class Solution {
    public String defangIPaddr(String address) {
        StringBuilder sb=new StringBuilder();
        String[] s=address.split("\\.");
        for(int i=0;i<s.length;i++){
            if(i==s.length-1){
                sb.append(s[i]);
            }
            else sb.append(s[i]).append("[.]");
        }
        return sb.toString();
    }
}