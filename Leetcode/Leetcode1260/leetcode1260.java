import java.util.*;

class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<Integer> list = new ArrayList<>();
        for (int[] row : grid) {
            for (int num : row) {
                list.add(num);
            }
        }

        int len = list.size();
        int offset = k % len;
        List<Integer> left = list.subList(0, len - offset);
        List<Integer> right = list.subList(len - offset, len);

        List<Integer> total = new ArrayList<>(right);
        total.addAll(left);

        int rows = grid.length;
        int cols = grid[0].length;
        List<List<Integer>> result = new ArrayList<>();
        int idx = 0;
        for (int i = 0; i < rows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                row.add(total.get(idx++));
            }
            result.add(row);
        }

        return result;
    }
}