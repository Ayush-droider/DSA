class Solution {
    //5- min me pelunga tujhe to mai
    public int totalFruit(int[] fruits) {
        if(fruits.length==1)return 1;
        if(fruits.length==2 && fruits[0]==fruits[1])return 2;
        Map<Integer,Integer> map=new HashMap<>();
        int ans=0;
        int i=0,j=0;
        while(j<fruits.length){
            map.put(fruits[j],map.getOrDefault(fruits[j],0)+1);

            while(map.size()>2){
                int a=fruits[i];
                map.put(a,map.get(a)-1);
                if(map.get(a)==0)map.remove(a);
                i++;
            }
            ans=Math.max(ans,(j-i+1));
            j++;
        }
        return ans;
    }
}