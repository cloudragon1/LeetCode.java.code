import java.util.stream.IntStream;

class Solution {
    public int[] sortByBits(int[] arr) {
        return IntStream.of(arr)
                .boxed()
                .sorted((Integer a, Integer b) -> {
                    int ca = Integer.bitCount(a);
                    int cb = Integer.bitCount(b);
                    return ca != cb ? ca - cb : a - b;
                })
                .mapToInt(a -> a)
                .toArray();
    }
}