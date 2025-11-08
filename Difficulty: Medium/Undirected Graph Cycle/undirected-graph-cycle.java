import java.util.*;

class Solution {
    private class Pair {
        int first;
        int second;
        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    public boolean bfs(int src, int[] visited, ArrayList<ArrayList<Integer>> adj) {
        visited[src] = 1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src, -1));
        while (!q.isEmpty()) {
            int node = q.peek().first;
            int parent = q.peek().second;
            q.poll();
            for (int adjNode : adj.get(node)) {
                if (visited[adjNode] == 0) {
                    visited[adjNode] = 1;
                    q.add(new Pair(adjNode, node));
                } else if (adjNode != parent) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean isCycle(int V, int[][] edges) {
        int[] visited = new int[V];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                if (bfs(i, visited, adj)) return true;
            }
        }

        return false;
    }
}
