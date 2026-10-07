import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        
        int max = Integer.MIN_VALUE;
        for(int i = 0; i <= n - 3; i++) {
            for(int j = 0; j <= n - 3; j++) {
                int sum = 0;

                for(int p = 0; p < 3; p++) {
                    for(int q = 0; q < 3; q++) {
                        sum += grid[i + p][j + q];
                    }
                }

                max = Math.max(max, sum);
            }
        }

        System.out.print(max);
    }
}