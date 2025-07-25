import java.util.*;

public class LinkStateRouting {
    static class Graph {
        int vertices;
        List<Map<Integer, Integer>> adjList;

        public Graph(int vertices) {
            this.vertices = vertices;
            adjList = new ArrayList<>();
            for (int i = 0; i < vertices; i++) {
                adjList.add(new HashMap<>());
            }
        }

        public void addEdge(int src, int dest, int weight) {
            adjList.get(src - 1).put(dest, weight);
            // For undirected graph, add the reverse edge
            adjList.get(dest - 1).put(src, weight);
        }
    }

    public static int[] dijkstra(Graph graph, int start) {
        int[] dist = new int[graph.vertices];
        boolean[] visited = new boolean[graph.vertices];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start - 1] = 0;

        for (int i = 0; i < graph.vertices; i++) {
            int u = minDistance(dist, visited);
            visited[u] = true;

            for (Map.Entry<Integer, Integer> neighbor : graph.adjList.get(u).entrySet()) {
                int v = neighbor.getKey();
                int weight = neighbor.getValue();
                if (!visited[v - 1] && dist[u] + weight < dist[v - 1]) {
                    dist[v - 1] = dist[u] + weight;
                }
            }
        }
        return dist;
    }

    private static int minDistance(int[] dist, boolean[] visited) {
        int min = Integer.MAX_VALUE, minIndex = -1;
        for (int v = 0; v < dist.length; v++) {
            if (!visited[v] && dist[v] <= min) {
                min = dist[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    public static void main(String[] args) {
        // Create the graph based on your network
        Graph graph = new Graph(5);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 2);
        graph.addEdge(2, 3, 1);
        graph.addEdge(2, 4, 3);
        graph.addEdge(3, 4, 1);
        graph.addEdge(3, 5, 4);
        graph.addEdge(4, 5, 2);

        // Generate routing table for each node
        for (int node = 1; node <= graph.vertices; node++) {
            System.out.println("Routing table for Node " + node + ":");
            int[] distances = dijkstra(graph, node);
            for (int dest = 1; dest <= graph.vertices; dest++) {
                System.out.println("  To Node " + dest + ", Cost: " + distances[dest - 1]);
            }
            System.out.println();
        }
    }
}
