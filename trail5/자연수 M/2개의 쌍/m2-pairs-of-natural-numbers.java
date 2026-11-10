import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> order = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            map.put(y, x);
            order.add(y);
        }
        
        Collections.sort(order);
        int start = 0, end = order.size() - 1;
        int answer = Integer.MIN_VALUE;

        while(true) {
            if(start == end) {
                int a = order.get(start);
                answer = Math.max(answer, 2 * a);   
                break;
            }

            int a = order.get(start);
            int b = order.get(end);

            answer = Math.max(answer, a + b);

            int aCnt = map.get(a);
            int bCnt = map.get(b);

            if(aCnt > bCnt) {
                end--;
                map.put(a, aCnt - bCnt);
            }
            else if(aCnt < bCnt) {
                start++;
                map.put(b, bCnt - aCnt);
            }
            else {
                start++; end--;
            }
        }

        System.out.print(answer);
    }
}