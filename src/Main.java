import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Task 1
        task1();
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
}