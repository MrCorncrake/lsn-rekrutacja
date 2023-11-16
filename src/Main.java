import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Choose task to run
        if (args.length > 0) {
            switch (args[0]) {
                case "task1":
                    task1();
                    break;
                case "task2":
                    task2();
                    break;
                case "task3":
                    task3();
                    break;
                default:
                    break;
            }
        }
    }

    private static void task1() {
        List<Integer> integerList = new ArrayList<>();

        // Get input
        final Scanner in = new Scanner(System.in);
        final StringTokenizer st = new StringTokenizer(in.nextLine(), " ");
        in.close();
        // Get values from input
        while(st.hasMoreTokens()) {
            integerList.add(Integer.parseInt(st.nextToken()));
        }

        // Save count
        final int count = integerList.size();
        // Keep only unique values
        integerList = new ArrayList<>(new HashSet<>(integerList));
        // Sort in ascending order
        Collections.sort(integerList);

        // Print result
        for (int i : integerList) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("count: " + count);
        System.out.println("distinct: " + integerList.size());
        System.out.println("min: " + integerList.get(0));
        System.out.println("max: " + integerList.get(integerList.size() - 1));
    }

    private static void task2() {
        List<Integer> integerList = new ArrayList<>();

        // Get input
        final Scanner in = new Scanner(System.in);
        final StringTokenizer st = new StringTokenizer(in.nextLine(), " ");
        in.close();
        // Get values from input
        while(st.hasMoreTokens()) {
            integerList.add(Integer.parseInt(st.nextToken()));
        }

        // Sort values
        Collections.sort(integerList);
        // Find pairs that sum to 13
        int sum, left = 0, right = integerList.size() - 1;
        while (left != right) {
            sum = integerList.get(left) + integerList.get(right);
            if (sum == 13) {
                System.out.println(integerList.get(left) + " " + integerList.get(right));
                left++;
            } else if (sum > 13) {
                right--;
            } else {
                left++;
            }
        }
    }

    private static void task3() {
        final Map<Integer, Set<Integer>> graph = new HashMap<>();

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
        int graphs = 0;
        final Set<Integer> visited = new HashSet<>();
        while (visited.size() != graph.size()) {
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