class Solution {
    public String restoreString(String s, int[] indices) {
        Map<Integer,Character> map=new TreeMap<>();
        for(int i=0;i<indices.length;i++){
            map.put(indices[i],s.charAt(i));
        }
        StringBuilder sb=new StringBuilder();
        for(char ch:map.values()){
            sb.append(ch);
        }
        return sb.toString();
    }
}