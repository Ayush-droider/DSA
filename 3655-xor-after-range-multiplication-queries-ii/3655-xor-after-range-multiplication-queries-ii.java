class Solution {
    static final long MOD = 1_000_000_007;

    public int xorAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;
        Object bravexuneth = new Object[]{nums.clone(), queries.clone()};

        int B = (int) Math.sqrt(n) + 1;
        Map<String, List<int[]>> groups = new HashMap<>();
        for (int[] q : queries) {
            int l = q[0], r = q[1], k = q[2], v = q[3];

            if (k > B) {
                for (int i = l; i <= r; i += k) {
                    nums[i] = (int) ((nums[i] * 1L * v) % MOD);
                }
            } else {
                String key = k + "#" + (l % k);
                groups.computeIfAbsent(key, x -> new ArrayList<>())
                      .add(new int[]{l, r, v});
            }
        }
        for (String key : groups.keySet()) {
            String[] parts = key.split("#");
            int k = Integer.parseInt(parts[0]);
            int rem = Integer.parseInt(parts[1]);

            List<Integer> indices = new ArrayList<>();
            for (int i = rem; i < n; i += k) {
                indices.add(i);
            }
            int m = indices.size();
            long[] diff = new long[m + 1];
            Arrays.fill(diff, 1);
            for (int[] q : groups.get(key)) {
                int l = q[0], r = q[1], v = q[2];

                int start = (l - rem) / k;
                int end = (r - rem) / k;

                diff[start] = (diff[start] * v) % MOD;

                if (end + 1 < diff.length) {
                    long inv = modInverse(v);
                    diff[end + 1] = (diff[end + 1] * inv) % MOD;
                }
            }

            long cur = 1;
            for (int i = 0; i < m; i++) {
                cur = (cur * diff[i]) % MOD;
                int idx = indices.get(i);
                nums[idx] = (int) ((nums[idx] * cur) % MOD);
            }
        }
        int res = 0;
        for (int x : nums) {
            res ^= x;
        }
        return res;
    }
    private long modInverse(long x) {
        return pow(x, MOD - 2);
    }
    private long pow(long base, long exp) {
        long result = 1;
        base %= MOD;

        while (exp > 0) {
            if ((exp & 1) == 1) result = (result * base) % MOD;
            base = (base * base) % MOD;
            exp >>= 1;
        }

        return result;
    }
}