import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            int u = e[0], v = e[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] visited = new boolean[n];
        int target = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int[] point = new int[2];
                dfs(i, graph, visited, point);
                int k = point[0];
                if (point[1] == k * (k - 1)) {
                    target++;
                }
            }
        }
        return target;
    }

    private void dfs(int u, List<List<Integer>> graph, boolean[] visited, int[] point) {
        visited[u] = true;
        point[0]++;
        point[1] += graph.get(u).size();
        for (int v : graph.get(u)) {
            if (!visited[v]) {
                dfs(v, graph, visited, point);
            }
        }
    }
}

