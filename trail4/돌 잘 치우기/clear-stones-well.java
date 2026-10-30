import java.util.*;
public class Main {

    static int n, k, m;
    static int[][] grid;
    static int[][] startPoints;
    static List<int[]> rocks;
    static boolean[][] visited;
    static int answer = Integer.MIN_VALUE;

    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][n];
        rocks = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();

                if(grid[i][j] == 1) {
                    rocks.add(new int[]{i, j});
                }
            }
        }
        startPoints = new int[k][2];
        for (int i = 0; i < k; i++) {
            startPoints[i][0] = sc.nextInt() - 1;
            startPoints[i][1] = sc.nextInt() - 1;
        }
        
        pick(0, 0);
        System.out.print(answer);
    }

    public static void pick(int cnt, int idx) {
        if(cnt == m) {
            visited = new boolean[n][n];

            for(int i = 0; i < k; i++) {
                int r = startPoints[i][0], c = startPoints[i][1];
                bfs(r, c);
            }

            int count = 0;
            for(int i = 0; i <n; i++) {
                for(int j = 0; j < n; j++) {
                if(visited[i][j]) count++;
                }
            }

            answer = Math.max(answer, count);

            return;
        }

        if(idx >= rocks.size()) return;

        int[] cur = rocks.get(idx);
        int cr = cur[0], cc = cur[1];

        grid[cr][cc] = 0;
        pick(cnt + 1, idx + 1);
        grid[cr][cc] = 1;
        pick(cnt , idx + 1);
    }

    public static void bfs(int r, int c) {
        Queue<int[]> q = new ArrayDeque<>();

        q.offer(new int[]{r, c});
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
                q.offer(new int[]{nr, nc});
            }

        }
    }
}