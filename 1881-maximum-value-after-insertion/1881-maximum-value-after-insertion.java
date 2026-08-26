class Solution {
    public String maxValue(String n, int x) {
        char sign=n.charAt(0);
        StringBuilder sb=new StringBuilder();

        if(sign!='-'){
            int j=0;
            while(j<n.length() && n.charAt(j)-'0'>=x){
                j++;

            }
            sb.append(n.substring(0,j)).append(x).append(n.substring(j));
        }
        else{
            int k=1;
            while(k<n.length() && n.charAt(k)-'0'<=x){
                k++;
            }
            sb.append(n.substring(0,k)).append(x).append(n.substring(k));
        }
        return sb.toString();
    }
}