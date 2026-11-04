import java.util.Scanner;
import java.util.*;
public class Main {

    static int n, m;
    static int[][] grid;

    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();
        
        System.out.print(bfs() ? 1 : 0);
    }

    public static boolean bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];

        q.add(new int[]{0, 0});
        visited[0][0] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int cr = cur[0], cc = cur[1];

            if(cr == (n - 1) && cc == (m - 1)) return true;

            for(int d = 0; d < 4; d++) {
                int nr = cr + dr[d];
                int nc = cc + dc[d];

                if(nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                if(visited[nr][nc]) continue;
                if(grid[nr][nc] == 0) continue;

                visited[nr][nc] = true;
                q.add(new int[]{nr, nc});
            }
        }

        return false;
    }
}