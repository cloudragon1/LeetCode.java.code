/*
import java.util.Set;

class Solution {
    private static final Set<Integer> primes = Set.of(2, 3, 5, 7, 11, 13, 17, 19);

    public int countPrimeSetBits(int left, int right) {
        int ans = 0;
        for (int x = left; x <= right; x++) {
            if (primes.contains(Integer.bitCount(x))) {
                ans++;
            }
        }
        return ans;
    }
}*/

import java.util.Arrays;
import java.util.Set;

class Solution {
    private static final Set<Integer> primes = Set.of(2, 3, 5, 7, 11, 13, 17, 19);

    public int countPrimeSetBits(int left, int right) {
        int n = 32 - Integer.numberOfLeadingZeros(right);
        int[][] memo = new int[n][n + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dfs(n - 1, 0, true, true, left, right, memo);
    }

    // 在 dfs 的过程中，统计二进制中的 1 的个数 cnt1
    private int dfs(int i, int cnt1, boolean limitLow, boolean limitHigh, int left, int right, int[][] memo) {
        if (i < 0) {
            return primes.contains(cnt1) ? 1 : 0;
        }
        if (!limitLow && !limitHigh && memo[i][cnt1] != -1) {
            return memo[i][cnt1];
        }

        int lo = limitLow ? left >> i & 1 : 0;
        int hi = limitHigh ? right >> i & 1 : 1;

        int res = 0;
        for (int d = lo; d <= hi; d++) {
            res += dfs(i - 1, cnt1 + d, limitLow && d == lo, limitHigh && d == hi, left, right, memo);
        }

        if (!limitLow && !limitHigh) {
            memo[i][cnt1] = res;
        }
        return res;
    }
}