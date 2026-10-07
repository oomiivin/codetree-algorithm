import java.util.Scanner;

public class Main {
    static int max = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        
        func(0, 0, new int[m], n, m, A);
        System.out.print(max);
    }

    public static void func(int cnt, int start, int[] arr, int n, int m, int[] A) {
        if(cnt == m) {
            int k = arr[0];
            for(int i = 1; i < m; i++) {
                k ^= arr[i];
            }

            max = Math.max(max, k);
            return;
        }

        for(int i = start; i < n; i++) {
            arr[cnt] = A[i];
            func(cnt + 1, i + 1, arr, n, m, A);
        }
    }
}