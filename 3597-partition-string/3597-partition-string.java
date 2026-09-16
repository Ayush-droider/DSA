class Solution {
    public List<String> partitionString(String s) {
        List<String> list=new ArrayList<>();
        HashSet<String> set=new HashSet<>();
        String st="";
        for(int i=0;i<s.length();i++){
            st+=s.charAt(i);
            if(!set.contains(st)){
                list.add(st);
                set.add(st);
                st="";
            }
        }
        return list;
    }
}