class Solution {
    private int gcd(int a,int b){
        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }

    private int lcm(int a, int b) {
        return Math.abs(a/gcd(a,b)*b);
    }
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> list=new ArrayList<>();
        for(int num:nums){
            list.add(num);

            while(list.size()>=2){
                int a=list.get(list.size()-2);
                int b=list.get(list.size()-1);

                if(gcd(a,b)==1){
                    break;
                }

                int lcm=lcm(a, b);

                list.remove(list.size()-1);
                list.remove(list.size()-1);
                list.add(lcm);
            }
        }

        return list;
    }
}