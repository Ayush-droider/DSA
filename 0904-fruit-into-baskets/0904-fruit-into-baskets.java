class Solution {
    //2- basket hai wahi k hai hamara
    //ab kaam ye kar map le fruits collect kar per agar tujhe kisi aur type
    //ka jyada mil rha to update maar left se hatake....FUCKED......
    //ek aur cheej sb kuch basket cap ke ander rakhna
    public int totalFruit(int[] fruits) {
        // if(fruits.length==1)return 1;
        int i=0,j=0;
        Map<Integer,Integer> map=new HashMap<>();
        int ans=Integer.MIN_VALUE;
        while(j<fruits.length){
            map.put(fruits[j],map.getOrDefault(fruits[j],0)+1);

            // if(map.size()==2){
            // }

            while(map.size()>2){
                int left=fruits[i];
                map.put(left,map.get(left)-1);
                if(map.get(left)==0)map.remove(left);
                i++;
            }
            ans=Math.max(ans,(j-i+1));
            j++;
        }
        return (ans==Integer.MIN_VALUE)?0:ans;
    }
}