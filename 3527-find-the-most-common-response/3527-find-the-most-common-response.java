class Solution {
    public String findCommonResponse(List<List<String>> responses) {
        HashMap<String,Integer> map=new HashMap<>();
        for(List<String> l:responses){
            HashSet<String> set = new HashSet<>(l);
            for(String s:set){
                map.put(s,map.getOrDefault(s,0)+1);
            }
        }
        String key="";
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            String s=entry.getKey();
            int count=entry.getValue();

            if (key.equals("") || count>map.get(key) || (count == map.get(key) && s.compareTo(key)<0)){
                key=s;
            }
        }
        return key;
    }
}