import java.util.*;

class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1); 
        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (!bfsCheck(i, graph, color)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean bfsCheck(int start, int[][] graph, int[] color) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        color[start] = 0; 

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int neighbor : graph[node]) {
                if (color[neighbor] == -1) {
                    color[neighbor] = 1 - color[node];
                    q.add(neighbor);
                } 
                else if (color[neighbor] == color[node]) {
                    return false;
                }
            }
        }
        return true;
    }
}
