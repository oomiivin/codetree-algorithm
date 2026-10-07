import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        int ans = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {

                for(int k = 0; k <= 2 * n; k++) {
                    int count = 0;

                    for(int r = 0; r < n; r++) {
                        for(int c = 0; c < n; c++) {

                            if(Math.abs(i - r) + Math.abs(j - c) <= k) {
                                if(grid[r][c] == 1) {
                                    count++;
                                }
                            }
                        }
                    }

                    if(k * k + (k + 1) * (k + 1) <= m * count) {
                        ans = Math.max(ans, count);
                    }
                }
            }
        }

        System.out.print(ans);
    }
}