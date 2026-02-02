class Solution {

    static class Pair {
        int node;
        int weight;

        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public int[] dijkstra(int V, int[][] edges, int src) {

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            int wt = e[2];

            adj.get(u).add(new Pair(v, wt));
            adj.get(v).add(new Pair(u, wt)); // undirected
        }

        int[] dist = new int[V];
        Arrays.fill(dist, (int) 1e9);
        dist[src] = 0;

        // Min heap: (distance, node)
        PriorityQueue<Pair> pq =
            new PriorityQueue<>((a, b) -> a.weight - b.weight);

        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            int node = cur.node;
            int curDist = cur.weight;

            if (curDist > dist[node]) continue;

            for (Pair it : adj.get(node)) {
                int nextNode = it.node;
                int edgeWt = it.weight;

                if (dist[node] + edgeWt < dist[nextNode]) {
                    dist[nextNode] = dist[node] + edgeWt;
                    pq.add(new Pair(nextNode, dist[nextNode]));
                }
            }
        }

        return dist;
    }
}
