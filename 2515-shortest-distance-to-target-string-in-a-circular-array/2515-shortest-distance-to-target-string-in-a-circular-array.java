class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n=words.length;
        for(int i=0;i<n;i++){
            String next=words[(startIndex+i)%n];
            String prev=words[(startIndex-i+n)%n];

            if(next.equals(target) || prev.equals(target))return i;
        }
        return -1;
    }
}