class Solution {
    public int buyChoco(int[] prices, int money) {
        int m=money;
        int ans=0;
        Arrays.sort(prices);
        for(int p:prices){
            if(ans==2)break;
            if(p<=money){
                money-=p;
                ans++;
            }
        }
        return (ans==2)?money:m;
    }
}