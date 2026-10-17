class Solution {
    private class Pair {
        int num;
        int sumOfNum;

        Pair(int num,int sumOfNum){
            this.num=num;
            this.sumOfNum=sumOfNum;
        }
    }

    private int calcSum(int num){
        int r=0, sum=0;
        while(num!=0){
            r=num%10;
            sum+=r;
            num/=10;
        }
        return sum;
    }

    public int minSwaps(int[] nums){
        int n=nums.length;
        Pair[] arr=new Pair[n];

        for(int i=0;i<n;i++){
            arr[i]=new Pair(nums[i],calcSum(nums[i]));
        }

        Arrays.sort(arr,(a,b)->{
            if(a.sumOfNum!=b.sumOfNum){
                return Integer.compare(a.sumOfNum,b.sumOfNum);
            } else{
                return Integer.compare(a.num, b.num);
            }
        });

        Map<Integer,Integer> indexMap=new HashMap<>();

        for(int i=0;i<n;i++) {
            indexMap.put(nums[i],i);
        }

        int swaps=0;
        boolean[] visited=new boolean[n];

        for(int i=0; i<n; i++){
            if(visited[i] || indexMap.get(arr[i].num)==i){
                visited[i]=true;
                continue;
            }

            int j=i;
            int cycleSize=0;

            while(!visited[j]){
                visited[j]=true;
                j=indexMap.get(arr[j].num);
                cycleSize++;
            }
            swaps+=cycleSize-1;
        }
        return swaps;
    }
}