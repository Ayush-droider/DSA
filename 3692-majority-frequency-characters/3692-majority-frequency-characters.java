class Solution {
    public String majorityFrequencyGroup(String s) {
        HashMap<Character, Integer> freq=new HashMap<>();
        for(char ch:s.toCharArray()){
            freq.put(ch,freq.getOrDefault(ch,0)+1);
        }
        HashMap<Integer,List<Character>> map=new HashMap<>();
        for(char key:freq.keySet()){
            int f=freq.get(key);
            map.putIfAbsent(f,new ArrayList<>());
            map.get(f).add(key);
        }
        List<Character> ans = new ArrayList<>();
        int bestFreq = -1;

        for (int f:map.keySet()) {
            List<Character> curr=map.get(f);

            if (curr.size()>ans.size() ||
                (curr.size()==ans.size() && f>bestFreq)){
                ans=curr;
                bestFreq=f;
            }
        }
        StringBuilder sb=new StringBuilder();
        for(char ch:ans){
            sb.append(ch);
        }
        return sb.toString();
        // HashMap<Integer,Integer> map=new HashMap<>();
        // for(int val:freq.values()){
        //     map.put(val,map.getOrDefault(val,0)+1);
        // }
        // Map<Integer,List<Character> ch> map1=new HashMap<>();
        // for(int x:map.values()){
        //     for(char key:freq.keySet()){
        //         if(freq.get(key)==x)map1.put(x,map1.getOrDefault(x,))
        //     }
        // }

        // for(int )
        // HashMap<Integer,Integer> map=new HashMap<>();
        // for(int val:freq.values()){
        //     map.put(val,map.getOrDefault(val,0)+1);
        // }
        // int maxi=-1;
        // for(int key:map.keySet()){
        //     if(map.get(key)>maxi){
        //         maxi=key;
        //     }
        // }
        // StringBuilder sb=new StringBuilder();
        // for(char key:freq.keySet()){
        //     if(freq.get(key)==maxi)sb.append(key);
        // }
        // return sb.toString();
    }
}