import java.util.*;

class Solution {
    static void dfs(int node, ArrayList<ArrayList<Integer>> adjLs, int[] visited) {
        visited[node] = 1;
        for (Integer it : adjLs.get(node)) {
            if (visited[it] == 0)
                dfs(it, adjLs, visited);
        }
    }
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        ArrayList<ArrayList<Integer>> adjLs = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjLs.add(new ArrayList<>());
        }

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (adj.get(i).get(j) == 1 && i != j) {
                    adjLs.get(i).add(j);
                    adjLs.get(j).add(i);
                }
            }
        }
        int[] visited = new int[V];
        int cnt = 0;

        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                cnt++;
                dfs(i, adjLs, visited);
            }
        }

        return cnt;
    }
}
