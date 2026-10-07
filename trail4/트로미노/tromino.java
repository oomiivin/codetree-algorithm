import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= m - 3; j++) {
                int sum = grid[i][j] + grid[i][j + 1] + grid[i][j + 2];
                max = Math.max(max, sum);
            }
        }
        for(int j = 0; j < m; j++) {
            for(int i = 0; i <= n - 3; i++) {
                int sum = grid[i][j] + grid[i + 1][j] + grid[i + 2][j];
                max = Math.max(max, sum);
            }
        }

        int[][] dr = {{-1, -1}, {-1, -1}, {-1, 0}, {1, 0}, {1, 1}, {1, 1}, {-1, 0}, {1, 0}};
        int[][] dc = {{-1, 0}, {0, 1}, {1, 1}, {1, 1}, {-1, 0}, {0, -1}, {-1, -1}, {-1, -1}};

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                for(int d = 0; d < 8; d++) {
                    boolean flag = true;
                    int sum = grid[i][j];

                    for(int k = 0; k < 2; k++) {
                        int nr = i + dr[d][k];
                        int nc = j + dc[d][k];

                        if(nr < 0 || nr >= n || nc < 0 || nc >= m) {
                            flag = false;
                            break;
                        }

                        sum += grid[nr][nc];
                    }

                    if(flag) {
                        max = Math.max(max, sum);
                    }
                }
            }
        }

        System.out.print(max);
    }
}