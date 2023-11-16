import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Task 2
        task2();   
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
}