import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        Map<Integer, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(sc.nextLine());
            String comm = st.nextToken();

            if(comm.equals("add")) {
                int key = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());
                map.put(key, value);
            }
            else if(comm.equals("remove")) {
                int key = Integer.parseInt(st.nextToken());
                map.remove(key);
            }
            else {
                int key = Integer.parseInt(st.nextToken());

                if(map.containsKey(key)) sb.append(map.get(key) + "\n");
                else sb.append("None\n");
            }
        }

        System.out.print(sb);
    }
}