class Solution {
    private void fwt(long[] a, boolean invert) {
        int n = a.length;
        for (int len = 1; len < n; len <<= 1) {
            for (int i = 0; i < n; i += len << 1) {
                for (int j = 0; j < len; j++) {
                    long u = a[i + j], v = a[i + j + len];
                    a[i + j] = u + v;
                    a[i + j + len] = u - v;
                }
            }
        }
        if (invert) {
            for (int i = 0; i < n; i++) {
                a[i] /= n;
            }
        }
    }

    public int uniqueXorTriplets(int[] nums) {
        int m = 2048;
        long[] a = new long[m];
        for (int v : nums) {
            a[v]++;
        }
        fwt(a, false);
        for (int i = 0; i < m; i++) {
            a[i] = a[i] * a[i] * a[i];
        }
        fwt(a, true);
        int ans = 0;
        for (long x : a) {
            if (x > 0) {
                ans++;
            }
        }
        return ans;
    }
}