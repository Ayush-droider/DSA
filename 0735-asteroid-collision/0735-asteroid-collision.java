class Solution {
    private class Steroid{
        int size;
        char dir;
        int pos;

        Steroid(int size,int pos,char dir){
            this.size=size;
            this.pos=pos;
            this.dir=dir;
        }
    }
    public int[] asteroidCollision(int[] asteroids) {
        int n=asteroids.length;
        Steroid[] s=new Steroid[n];
        Stack<Steroid> st=new Stack<>();
        for(int i=0;i<n;i++){
            if(asteroids[i]>=0){
                s[i]=new Steroid(asteroids[i],i,'R');
            }
            else s[i]=new Steroid(Math.abs(asteroids[i]),i,'L');
        }
        for(int i=0;i<asteroids.length;i++){
            Steroid curr=s[i];

            while(!st.isEmpty() && st.peek().dir=='R' && curr.dir=='L'){
                Steroid top=st.peek();

                if(top.size<Math.abs(curr.size)){
                    st.pop();
                }
                else if(top.size==Math.abs(curr.size)){
                    st.pop();
                    curr=null;
                    break;
                }
                else{
                    curr=null;
                    break;
                }
            }
            if(curr!=null)st.push(curr);
        }
        int[] res = new int[st.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            Steroid so = st.pop();
            res[i] = so.dir == 'R' ? so.size : -so.size;
        }

        return res;
    }
}