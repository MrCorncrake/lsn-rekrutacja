import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Task 3
        task3();
    }

    private static void task3() {
        Map<Integer, Set<Integer>> graph = new HashMap<>();

        // Read graph
        final Scanner in = new Scanner(System.in);
        int src, dest, n = in.nextInt();
        for (int i = 0; i < n; i++) {
            src = in.nextInt();
            dest = in.nextInt();

            if (graph.containsKey(src)) {
                graph.get(src).add(dest);
            } else {
                graph.put(src, new HashSet<>());
                graph.get(src).add(dest);
            }
            // Edges work both ways
            if (graph.containsKey(dest)) {
                graph.get(dest).add(src);
            } else {
                graph.put(dest, new HashSet<>());
                graph.get(dest).add(src);
            }
        }
        in.close();

        // Find all disconnected graphs
        int graphs = 0, vertices = graph.size();
        Set<Integer> visited = new HashSet<>();
        while (visited.size() != vertices) {
            // Find unvisited vertex
            for (int v : graph.keySet()) {
                if (!visited.contains(v)) {
                    // Search graph
                    dfs(graph, visited, v);
                    graphs++;
                    break;
                }
            }
        }
        System.out.println(graphs);
    }

    private static void dfs(Map<Integer, Set<Integer>> graph, Set<Integer> visited, int source) {
        visited.add(source);
        for (int v : graph.get(source)) {
            if (!visited.contains(v)) {
                dfs(graph, visited, v);
            }
        }
    }
}