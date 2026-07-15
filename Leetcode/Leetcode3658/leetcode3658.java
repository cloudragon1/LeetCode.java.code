class Solution {
    public int gcdOfOddEvenSums(int n) {
        int sumOdd = n * n;
        int sumEven = n * (n + 1);

        /*由于n和n+1的最大公约数就是1，所以sumOdd和sumEven的最大公约数是n*/
        return n;
    }
}