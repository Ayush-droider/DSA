import java.math.BigInteger;

class Solution {
    public int numSteps(String s) {
        int steps=0;
        BigInteger num=new BigInteger(s,2);
        while(!num.equals(BigInteger.ONE)){
            steps++;
            if (num.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO)) {
                num = num.divide(BigInteger.valueOf(2));
            } else {
            num = num.add(BigInteger.ONE);
            }
        }
        return steps;
    }
}