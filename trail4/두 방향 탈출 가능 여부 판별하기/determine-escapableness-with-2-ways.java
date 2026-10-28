import java.util.Scanner;
public class Main {

    static int n, m;
    static int[][] grid;
    static boolean flag = false;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();
        
        visited[0][0] = true;
        dfs(0, 0);
        System.out.println(flag ? 1 : 0);
    }

    public static void dfs(int r, int c) {
        if(flag) return;

        if(r == (n - 1) && c == (m - 1)) {
            flag = true;
            return;
        }

        int nr = r, nc = c + 1;
        if(nr >= 0 && nr < n && nc >= 0 && nc < m) {
            if(grid[nr][nc] == 1 && !visited[nr][nc]) {
                visited[nr][nc] = true;
                dfs(nr, nc);
            }
        }

        nr = r + 1; nc = c;
        if(nr >= 0 && nr < n && nc >= 0 && nc < m) {
            if(grid[nr][nc] == 1 && !visited[nr][nc]) {
                visited[nr][nc] = true;
                dfs(nr, nc);
            }
        }
    }
}