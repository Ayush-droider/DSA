class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> list=new ArrayList<>();
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            map.put(ch,i);
        }
        int prev=-1;
        int end=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            int lastIndexOfch=map.get(ch);
            end=Math.max(end,lastIndexOfch);
            if(i==end){
                list.add(end-prev);
                prev=end;
            }
        }
        return list;
    }
}