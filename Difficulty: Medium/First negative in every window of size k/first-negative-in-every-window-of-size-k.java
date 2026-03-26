class Solution {
    static List<Integer> firstNegInt(int arr[], int k) {
        // write code here
        Queue<Integer> q=new LinkedList<>();
        List<Integer> ans=new ArrayList<>();
        int n=arr.length;
        int i=0,j=0;
        while(j<n){
            if(arr[j]<0)q.add(arr[j]);
            
            if((j-i+1)==k){
                if(q.isEmpty())ans.add(0);
                else ans.add(q.peek());
                
                if(arr[i]<0){
                    q.poll();
                }
                i++;
            }
            j++;
        }
        return ans;
    }
}