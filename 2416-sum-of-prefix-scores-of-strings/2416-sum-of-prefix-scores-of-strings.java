class Solution {

    public int[] sumPrefixScores(String[] words) {

        int[] ans=new int[words.length];

        HashMap<Long,Integer> map=new HashMap<>();

        for(String word:words){

            long key=0;

            for(int i=0;i<word.length();i++){

                key=key*27+(word.charAt(i)-'a'+1);

                map.put(key,map.getOrDefault(key,0)+1);

            }

        }

        for(int i=0;i<words.length;i++){

            long key=0;

            for(int j=0;j<words[i].length();j++){

                key=key*27+(words[i].charAt(j)-'a'+1);

                ans[i]+=map.get(key);

            }

        }

        return ans;

    }

}