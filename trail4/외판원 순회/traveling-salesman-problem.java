import java.util.Scanner;

public class Main {

    static int n;
    static int answer = Integer.MAX_VALUE;
    static int[][] cost;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        cost = new int[n][n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = sc.nextInt();
            }
        }
        
        visited[0] = true;
        func(0, 1, 0);
        System.out.println(answer);
    }

    public static void func(int total, int count, int pre) {
        if(count == n) {
            if(cost[pre][0] != 0) {
                answer = Math.min(total + cost[pre][0], answer);
            }

            return;
        }

        if(total >= answer) return;

        for(int i = 0; i < n; i++) {
            if(visited[i]) continue;
            if(cost[pre][i] == 0) continue;

            visited[i] = true;
            func(total + cost[pre][i], count + 1, i);
            visited[i] = false;
        }
    }
}