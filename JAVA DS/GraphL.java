import java.util.*;

class GraphL {
    int V;
    private LinkedList<Integer>[] arr;

    @SuppressWarnings("unchecked")
    GraphL(int node) {
        this.V = node;
        arr = new LinkedList[node];
        for (int a = 0; a < V; a++) {
            arr[a] = new LinkedList<>();
        }
    }

    public void insert(int s, int d) {
        if (s < 0 || s >= V || d < 0 || d >= V) {
            System.out.println("Invalid vertices! Please enter values between 0 and " + (V - 1));
            return;
        }
        arr[s].add(d);
        arr[d].add(s);
    }

    public void print() {
        System.out.println("\nGraph Adjacency List:");
        for (int i = 0; i < V; i++) {
            System.out.println("Vertex " + i + ": " + arr[i]);
        }
    }

    public void dfs(int s) {
        if (s < 0 || s >= V) {
            System.out.println("Invalid starting vertex for DFS.");
            return;
        }
        boolean[] visited = new boolean[V];
        Stack<Integer> s1 = new Stack<>();
        s1.push(s);
        System.out.println("DFS Traversal:");
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
        if (r < 0 || r >= V) {
            System.out.println("Invalid starting vertex for BFS.");
            return;
        }
        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        visited[r] = true;
        q.offer(r);
        System.out.println("BFS Traversal:");
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
        GraphL g = new GraphL(v);
        int choice;

        do {
            System.out.println("\n--- Graph Traversals Menu ---");
            System.out.println("1. Insert Edge");
            System.out.println("2. Print Graph");
            System.out.println("3. DFS Traversal");
            System.out.println("4. BFS Traversal");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = s.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter source vertex: ");
                    int l = s.nextInt();
                    System.out.print("Enter destination vertex: ");
                    int m = s.nextInt();
                    g.insert(l, m);
                    break;
                case 2:
                    g.print();
                    break;
                case 3:
                    System.out.print("Enter starting vertex for DFS: ");
                    int dfsStart = s.nextInt();
                    g.dfs(dfsStart);
                    break;
                case 4:
                    System.out.print("Enter starting vertex for BFS: ");
                    int bfsStart = s.nextInt();
                    g.bfs(bfsStart);
                    break;
                case 5:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please select from the menu.");
            }
        } while (choice != 5);
        s.close();
    }
}
