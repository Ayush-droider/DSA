class Solution {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> list=new ArrayList<>();
        for(String w:words){
            String[] st=w.split("\\"+separator);

            for(String s:st){
                if(!s.isEmpty()){
                    list.add(s);
                }
            }
        }
        return list;
    }
}