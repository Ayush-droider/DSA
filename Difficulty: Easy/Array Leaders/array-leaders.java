class Solution {
    static ArrayList<Integer> leaders(int arr[]) {
        // code here
        int maxfromRight=arr[arr.length-1];
        ArrayList<Integer> ans=new ArrayList<>();
        ans.add(maxfromRight);
        for(int i=arr.length-2;i>=0;i--){
            if(arr[i]>=maxfromRight){
                maxfromRight=arr[i];
                ans.add(arr[i]);
            }
        }
        Collections.reverse(ans);
        return ans;
    }
}
