import java.util.*;

class GraphL1 {
    int V;
    private LinkedList<Integer>[] arr;

    GraphL1(int node) {
        this.V = node;
        arr = new LinkedList[node];
        for (int a = 0; a < V; a++) {
            arr[a] = new LinkedList<>();
        }
    }

    public void insert(int s, int d) {
        if (s >= 0 && s < V && d >= 0 && d < V) {
            arr[s].add(d);
            arr[d].add(s);
        } else {
            System.out.println("Invalid vertex. Please try again.");
        }
    }

    public void print() {
        for (int i = 0; i < V; i++) {
            System.out.println("Vertex " + i + ": " + arr[i]);
        }
    }

    public void dfs(int s) {
        boolean[] visited = new boolean[V];
        Stack<Integer> s1 = new Stack<>();
        s1.push(s);
        System.out.println("DFS traversal starting from node " + s + ":");
        while (!s1.isEmpty()) {
            int u = s1.pop();
            if (!visited[u]) {
                visited[u] = true;
                System.out.print(u + " ");
                for (int v : arr[u]) {
                    if (!visited[v]) {
                        s1.push(v);
                    }
                }
            }
        }
        System.out.println();
    }

    public void bfs(int r) {
        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        visited[r] = true;
        q.offer(r);
        System.out.println("BFS traversal starting from node " + r + ":");
        while (!q.isEmpty()) {
            int u1 = q.poll();
            System.out.print(u1 + " ");
            for (int v1 : arr[u1]) {
                if (!visited[v1]) {
                    visited[v1] = true;
                    q.offer(v1);
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        int v = s.nextInt();
        GraphL1 g = new GraphL1(v);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Insert edge");
            System.out.println("2. Print graph");
            System.out.println("3. DFS traversal");
            System.out.println("4. BFS traversal");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = s.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the source vertex: ");
                    int src = s.nextInt();
                    System.out.print("Enter the destination vertex: ");
                    int dest = s.nextInt();
                    g.insert(src, dest);
                    break;

                case 2:
                    System.out.println("Graph adjacency list:");
                    g.print();
                    break;

                case 3:
                    System.out.print("Enter the starting vertex for DFS: ");
                    int dfsStart = s.nextInt();
                    g.dfs(dfsStart);
                    break;

                case 4:
                    System.out.print("Enter the starting vertex for BFS: ");
                    int bfsStart = s.nextInt();
                    g.bfs(bfsStart);
                    break;

                case 5:
                    System.out.println("Exiting program.");
                    s.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        }
    }
}
