class Solution {
    public String destCity(List<List<String>> paths) {
        HashMap<String,String> map=new HashMap<>();
        for(List<String> p:paths){
            map.put(p.get(0),p.get(1));
        }
        for(String s:map.values()){
            if(!map.containsKey(s))return s;
        }
        return "";
    }
}