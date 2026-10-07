import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        visited = new boolean[n + 1];
       
        func(0, 1, new int[m], n, m);
        System.out.print(sb);
    }

    public static void func(int cnt, int start, int[] arr, int n, int m) {
        if(cnt == m) {
            for(int i = 0; i < cnt; i++) {
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i = start; i <= n; i++) {
            if(visited[i]) continue;

            arr[cnt] = i;
            visited[i] = true;
            func(cnt + 1, i + 1, arr, n, m);
            visited[i] = false;
        }
    }
}