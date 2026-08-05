class Solution {
    public String sortSentence(String s) {
        Map<Integer,String> map=new TreeMap<>();
        String[] str=s.split(" ");
        for(String st:str){
            int num=(st.charAt(st.length()-1))-'0';
            map.putIfAbsent(num,st.substring(0,st.length()-1));
        }
        StringBuilder sb=new StringBuilder();
        for(String value:map.values()){
            sb.append(value).append(" ");
        }
        return sb.toString().trim();
    }
}