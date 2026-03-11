class Solution {
    static final long MOD = 1000000007;
    public int numberOfStableArrays(int zero, int one, int limit) {
        int maxN = zero + one;
        long[] fact = new long[maxN + 1];
        long[] invFact = new long[maxN + 1];
        fact[0] = 1;
        invFact[0] = 1;
        for (int i = 1; i <= maxN; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }
        invFact[maxN] = power(fact[maxN], MOD - 2);
        for (int i = maxN - 1; i >= 1; i--) {
            invFact[i] = (invFact[i + 1] * (i + 1)) % MOD;
        }
        int maxK = Math.min(zero, one + 1);
        long[] fOne = new long[maxK + 2];
        for (int k = 1; k <= maxK + 1; k++) {
            fOne[k] = F(one, k, limit, fact, invFact);
        }
        long ans = 0;
        for (int k = 1; k <= maxK; k++) {
            long fz = F(zero, k, limit, fact, invFact);
            if (fz == 0) continue;
            long fo = (fOne[k - 1] + 2 * fOne[k] + fOne[k + 1]) % MOD;
            ans = (ans + fz * fo) % MOD;
        }
        return (int) ans;
    }

    private long power(long baseVal, long exp) {

        long res = 1;
        baseVal %= MOD;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = (res * baseVal) % MOD;
            }

            baseVal = (baseVal * baseVal) % MOD;
            exp >>= 1;
        }

        return res;
    }

    private long C(int n, int k, long[] fact, long[] invFact) {

        if (k < 0 || k > n) return 0;

        return fact[n] * invFact[k] % MOD * invFact[n - k] % MOD;
    }

    private long F(int N, int K, int L, long[] fact, long[] invFact) {

        if (K <= 0 || K > N) return 0;

        long ans = 0;
        int maxJ = (N - K) / L;

        for (int j = 0; j <= maxJ; j++) {

            long term =
                    C(K, j, fact, invFact)
                            * C(N - j * L - 1, K - 1, fact, invFact)
                            % MOD;

            if ((j & 1) == 1) {
                ans = (ans - term + MOD) % MOD;
            } else {
                ans = (ans + term) % MOD;
            }
        }

        return ans;
    }
}