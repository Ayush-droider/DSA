class Solution {
    static List<Integer> firstNegInt(int arr[], int k) {
        // write code here
        int i=0,j=0;
        int n=arr.length;
        Queue<Integer> q=new LinkedList<>();
        List<Integer> list=new LinkedList<>();
        
        while(j<n){
            if(arr[j]<0)q.add(arr[j]);
            
            if(j-i+1==k){
                if(q.isEmpty())list.add(0);
                else list.add(q.peek());
                
                if(arr[i]<0)q.poll();
                i++;
            }
            j++;
        }
        return list;
    }
}