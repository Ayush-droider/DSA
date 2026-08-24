class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> res=new ArrayList<>();
        HashMap<String,Integer> map=new HashMap<>();
        for(int i=0;i<list1.length;i++){
            map.put(list1[i],i);
        }
        int minSum=Integer.MAX_VALUE;
        for(int j=0;j<list2.length;j++){
            if(map.containsKey(list2[j])){
                int sum=map.get(list2[j])+j;

                if(sum<minSum){
                    res.clear();
                    minSum=sum;
                    res.add(list2[j]);
                }
                else if(sum==minSum){
                    res.add(list2[j]);
                }
            }
        }
        String[] ans=new String[res.size()];
        int k=0;
        for(String s:res){
            ans[k++]=s;
        }
        return ans;
    }
}