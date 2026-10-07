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
        
        
        if(m == 1) {
            System.out.print(2 * n);
            return;
        }

        int count = 0;
        for(int i = 0; i < n; i++) {
            int[] num = new int[101];
            int pre = grid[i][0];
            num[pre] = 1;
            for(int j = 1; j < n; j++) {
                if(pre == grid[i][j]) {
                    num[grid[i][j]]++;
                }
                else {
                    num[pre] = 0;
                    pre = grid[i][j];
                    num[pre] = 1;
                }

                if(num[grid[i][j]] >= m) {
                    count++;
                    break;
                }
            }
        }

        for(int j = 0; j < n; j++) {
            int[] num = new int[101];
            int pre = grid[0][j];
            num[pre] = 1;
            for(int i = 1; i < n; i++) {
                if(pre == grid[i][j]) {
                    num[grid[i][j]]++;
                }
                else {
                    num[pre] = 0;
                    pre = grid[i][j];
                    num[pre] = 1;
                }

                if(num[grid[i][j]] >= m) {
                    count++;
                    break;
                }
            }
        }

        System.out.print(count);
    }
}