class Solution {
    public int findGCD(int[] nums) {
        int min = 1001, max = 0;
        for (int num : nums) {
            min = Math.min(num, min);
            max = Math.max(num, max);
        }
        return gcd(min, max);
    }

    public int gcd(int a, int b) {
        return (a % b == 0 ? b : gcd(b, a % b));
    }
}