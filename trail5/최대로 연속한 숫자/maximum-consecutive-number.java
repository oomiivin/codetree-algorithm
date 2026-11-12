import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int m = sc.nextInt();

        TreeMap<Integer, Integer> numbers = new TreeMap<>();
        TreeMap<Integer, Integer> cnts = new TreeMap<>();
        numbers.put(0, n);
        cnts.put(n + 1, 1);

        for (int i = 0; i < m; i++) {
            int k = sc.nextInt();
            int start = numbers.floorKey(k);
            int end = numbers.get(start);
            int count = end - start + 1;

            numbers.remove(start);
            numbers.put(start, k - 1);
            numbers.put(k + 1, end);

            cnts.put(k - start, cnts.getOrDefault(k - start, 0) + 1);
            cnts.put(end - k, cnts.getOrDefault(end - k, 0) + 1);

            if(cnts.get(count) == 1) cnts.remove(count);
            else cnts.put(count, cnts.get(count) - 1);

            sb.append(cnts.lastKey()).append("\n");
        }
        
        System.out.print(sb);
    }
}