class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> result=new ArrayList<>();
        int mini=Integer.MAX_VALUE;
        for(int i=1;i<arr.length;i++){
            mini=Math.min(mini,arr[i]-arr[i-1]);
        }
        for(int i=1;i<arr.length;i++){
            if((arr[i]-arr[i-1])==mini){
                List<Integer> pair=new ArrayList<>();
                pair.add(arr[i-1]);
                pair.add(arr[i]);
                result.add(pair);
            }
        }
        return result;
    }
}