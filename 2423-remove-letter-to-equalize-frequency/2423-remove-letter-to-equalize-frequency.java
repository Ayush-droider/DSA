class Solution {
    public boolean equalFrequency(String word) {
        int[] freq = new int[26];
        for(char ch:word.toCharArray()){
            freq[ch-'a']++;
        }

        for(int i=0; i<26; i++){
            if(freq[i]>0){
                freq[i]--;
                int f=0;
                boolean valid=true;
                for(int j=0; j<26;j++){

                    if(freq[j]>0){
                        if(f==0){
                            f=freq[j];
                        }
                        else if(freq[j]!=f){
                            valid = false;
                            break;
                        }
                    }
                }
                freq[i]++;
                if(valid){
                    return true;
                }
            }
        }
        return false;
    }
}