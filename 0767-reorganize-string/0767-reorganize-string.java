class Solution {
    public String reorganizeString(String s) {
        // int prev=-1;
        // StringBuilder sb=new StringBuilder();
        // StringBuilder sb2=new StringBuilder();
        // for(int i=0;i<s.length();i++){
        //     if(prev==-1 || s.charAt(prev)!=s.charAt(i)){
        //         sb.append(s.charAt(i));
        //         prev=i;
        //     }
        //     else sb2.append(s.charAt(i));
        // }
        // sb.append(sb2);
        // for(int i=1;i<sb.length();i++){
        //     if(sb.charAt(i)==sb.charAt(i-1))return "";
        // }
        // return sb.toString();
        Map<Character,Integer> freqMap=new HashMap<>();
        for(char ch:s.toCharArray()){
            freqMap.put(ch,freqMap.getOrDefault(ch,0)+1);
        }
        PriorityQueue<Character> pq=new PriorityQueue<>((a, b) -> freqMap.get(b) - freqMap.get(a));
        for(char c:freqMap.keySet()){
            pq.add(c);
        }
        StringBuilder sb=new StringBuilder();
        while(pq.size()>=2){
            char ch1=pq.poll();
            char ch2=pq.poll();

            sb.append(ch1);
            sb.append(ch2);

            freqMap.put(ch1,freqMap.get(ch1)-1);
            freqMap.put(ch2,freqMap.get(ch2)-1);

            if(freqMap.get(ch1)>0)pq.add(ch1);
            if(freqMap.get(ch2)>0)pq.add(ch2);
        }
        while(!pq.isEmpty()){
            char ch=pq.poll();
            if(freqMap.get(ch)>1)return "";
            sb.append(ch);
        }
        return sb.toString(); 
    }
}