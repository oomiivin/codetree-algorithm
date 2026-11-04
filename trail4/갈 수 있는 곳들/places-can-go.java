import java.util.Scanner;
import java.util.*;

public class Main {

    static int n, k;
    static int[][] grid;
    static int[][] starts;
    static boolean[][] visited;

    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        starts = new int[k][2];
        for (int i = 0; i < k; i++) {
            starts[i][0] = sc.nextInt() - 1;
            starts[i][1] = sc.nextInt() - 1;
        }
        
        visited = new boolean[n][n];
        for(int i = 0; i < k; i++) {
            bfs(starts[i][0], starts[i][1]);
        }

        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(visited[i][j]) count++;
            }
        }

        System.out.print(count);
    }

    public static void bfs(int r, int c) {
        Queue<int[]> q = new ArrayDeque<>();

        q.add(new int[]{r, c});
        visited[r][c] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int cr = cur[0], cc = cur[1];

            for(int d = 0; d < 4; d++) {
                int nr = cr + dr[d];
                int nc = cc + dc[d];

                if(nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
                if(visited[nr][nc]) continue;
                if(grid[nr][nc] == 1) continue;

                visited[nr][nc] = true;
                q.add(new int[]{nr, nc});
            }
        }
    }
}