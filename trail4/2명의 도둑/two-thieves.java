import java.util.*;

public class Main {

    static int n, m, c;
    static int maxValue;
    static int answer = Integer.MIN_VALUE;
    static int[][] grid;
    static List<int[]> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        c = sc.nextInt();

        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= n - m; j++) {
                maxValue = Integer.MIN_VALUE;
                maxCalc(i, j, j + m - 1, 0, 0);
                list.add(new int[]{i, j, j + m - 1, maxValue});
            }
        }

        select(0, 0, new int[2]);
        System.out.print(answer);
    }

    public static void select(int cnt, int start, int[] nums) {
        if(cnt == 2) {
            int value = list.get(nums[0])[3] + list.get(nums[1])[3];
            answer = Math.max(value, answer);
            return;
        }

        for(int i = start; i < list.size(); i++) {
            if(cnt == 1) {
                if(check(nums[0], i)) continue;
            }

            nums[cnt] = i;
            select(cnt + 1, i + 1, nums);
        }
    }

    public static boolean check(int a, int b) {
        int[] first = list.get(a);
        int[] second = list.get(b);

        if(first[0] != second[0]) return false;

        return first[2] >= second[1];
    }

    public static void maxCalc(int r, int start, int end, int value, int weight) {
        maxValue = Math.max(value, maxValue);

        for(int i = start; i <= end; i++) {
            if(weight + grid[r][i] > c) continue;

            maxCalc(r, i + 1, end, value + (grid[r][i] * grid[r][i]), weight + grid[r][i]); 
        }
    }
}