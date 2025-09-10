class Solution {
    static final long MOD = 1000000007;

    public int countGoodNumbers(long n) {
        long result = (pow(5, (n + 1) / 2) * pow(4, n / 2)) % MOD;
        return (int) result;
    }

    private long pow(long a, long b) {
        if (b == 0) {
            return 1;
        }
        long half = pow(a, b / 2);
        long res = (half * half) % MOD;
        if (b % 2 == 1) {
            res = (res * a) % MOD;
        }
        return res;
    }
}
