import java.lang.reflect.Array;
import java.util.Arrays;

class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int[] prefixGid = new int[n];
        int mx = 0;
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            mx = Math.max(mx, x);
            prefixGid[i] = gcd(x, mx);
        }
        Arrays.sort(prefixGid);
        long target = 0;
        for (int i = 0; i < n / 2; i++) {
            target += gcd(prefixGid[i], prefixGid[n-1-i]);
        }
        return target;
        }

    //辗转相除法求最大公约数
    private int gcd(int a, int b){
        while (a != 0) {
            int tmp = a;
            a = b % a;
            b = tmp;
        }
        return b;
    }
}