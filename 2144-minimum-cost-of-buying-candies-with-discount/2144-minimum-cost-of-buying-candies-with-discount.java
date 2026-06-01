class Solution {
    public int minimumCost(int[] cost) {
        int actCost=0;
        Arrays.sort(cost);
        int count=0;
        for(int i=cost.length-1;i>=0;i--){
            count++;
            if(count==3){
                count=0;
                continue;
            }
            actCost+=cost[i];
        }
        return actCost;
    }
}