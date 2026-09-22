class Solution {
    public int lengthLongestPath(String input) {
        String[] str = input.split("\n");

        StringBuilder sb=new StringBuilder();

        for(String s:str){
            sb.append(s).append("/");
        }
        sb.deleteCharAt(sb.length() - 1);

        int max=0;

        for(int i=0; i<str.length; i++){
            if(str[i].contains(".")){
                String path=str[i].substring(str[i].lastIndexOf("\t") + 1);
                int tabs=str[i].lastIndexOf("\t") + 1;
                for(int j=i-1; j>=0 && tabs>0; j--){
                    int currTabs=str[j].lastIndexOf("\t")+1;
                    if(currTabs<tabs){
                        String folder=str[j].substring(str[j].lastIndexOf("\t") + 1);
                        path=folder+"/"+path;
                        tabs=currTabs;
                    }
                }
                max=Math.max(max, path.length());
            }
        }
        return max;
    }
}