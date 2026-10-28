import java.util.Scanner;
import java.util.*;

public class Main {

    static int n, m;
    static List<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new List[n + 1];
        visited = new boolean[n + 1];

        for(int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            graph[u].add(v);
            graph[v].add(u);
        }
        
        visited[1] = true;
        dfs(1);

        int count = 0;
        for(int i = 2; i <= n; i++) {
            if(visited[i]) count++;
        }

        System.out.println(count);
    }

    public static void dfs(int cur) {
        for(int next : graph[cur]) {
            if(visited[next]) continue;

            visited[next] = true;
            dfs(next);
        }
    }
}