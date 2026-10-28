import java.util.Scanner;
import java.util.*;

public class Main {

    static int n;
    static int[][] grid;
    static boolean[][] visited;
    static List<Integer> list = new ArrayList<>();

    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
                
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j);
                }
            }
        }

        Collections.sort(list);
        System.out.println(list.size());
        for(int k : list) {
            System.out.println(k);
        }
    }

    public static void bfs(int r, int c) {
        Queue<int[]> queue = new ArrayDeque<>();
        int count = 1;

        visited[r][c] = true;
        queue.offer(new int[]{r, c});

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cr = cur[0], cc = cur[1];

            for(int d = 0; d < 4; d++) {
                int nr = cr + dr[d];
                int nc = cc + dc[d];

                if(nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
                if(visited[nr][nc]) continue;
                if(grid[nr][nc] == 0) continue;

                count++;
                visited[nr][nc] = true;
                queue.offer(new int[]{nr, nc});
            }
        }

        list.add(count);
    }
}