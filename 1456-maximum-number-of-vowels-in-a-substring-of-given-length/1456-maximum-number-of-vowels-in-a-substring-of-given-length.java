class Solution {
    private boolean isVowel(char ch){
        return (ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u');
    }
    public int maxVowels(String s, int k) {
        int i=0,j=0;
        int n=s.length();

        HashMap<Character,Integer> map=new HashMap<>();
        int ans=0;
        int count=0;

        while(j<n){
            char ch=s.charAt(j);

            if(isVowel(ch)){
                count++;
                map.put(ch,map.getOrDefault(ch,0)+1);
            }

            while((j-i+1)>k){
                char leftch=s.charAt(i);
                if(isVowel(leftch))count--;
                i++;
            }

            if((j-i+1)==k){
                ans=Math.max(ans,count);
            }
            j++;
        }
        return ans;
    }
}