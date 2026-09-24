class Solution {

    public int maximumUnits(int[][] boxTypes, int truckSize) {

        Arrays.sort(boxTypes,(a,b)->b[1]-a[1]);

        int sum=0,taken=0;

        for(int i=0;i<boxTypes.length;i++){

            if(taken<truckSize){
                int boxes=Math.min(boxTypes[i][0],truckSize-taken);
                sum+=boxes*boxTypes[i][1];
                taken+=boxes;
            }
        }

        return sum;

    }
}