import java.util.*;

class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> target = new ArrayList<>();
        int window = 12;
        int pow = 10;
        for (int length = 2; window <= high; length++) {
            pow *= 10;
            int window1 = window;
            for (int i = length; i <= 9 && window1 <= high; i++) {
                if (window1 >= low){
                    target.add(window1);
                }
                window1 = window1 * 10 + (i + 1) - (i + 1 - length) * pow;
            }
            window = window * 10 + (length + 1);
        }
        return target;
    }
}