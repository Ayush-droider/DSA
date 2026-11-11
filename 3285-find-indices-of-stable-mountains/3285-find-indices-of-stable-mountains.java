class Solution {
    public List<Integer> stableMountains(int[] height, int threshold) {
        List<Integer> list=new ArrayList<>();
        int n=height.length;
        for(int i=1;i<height.length;i++){
            if(height[i-1]>threshold){
                list.add(i);
            }
        }
        return list;
    }
}