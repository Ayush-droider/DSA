class Solution {
    private class Pair{
        int num;
        int count;
    }
    public int[] sortByBits(int[] arr) {
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        Pair[] p=new Pair[arr.length];
        for(int i=0;i<arr.length;i++){
            int c=Integer.bitCount(arr[i]);
            p[i]=new Pair();
            p[i].num=arr[i];
            p[i].count=c;
        }
        Arrays.sort(p,(x,y)->{
            if(x.count==y.count)return x.num-y.num;
            return x.count-y.count;
        });

        for(int i=0;i<p.length;i++){
            arr[i]=p[i].num;
        }
        return arr;
    }
}