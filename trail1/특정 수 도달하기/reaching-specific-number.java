import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int sum = 0, count = 0;
        for(int i = 0; i < 10; i++) {
            int k = Integer.parseInt(st.nextToken());

            if(k >= 250) break;
            else {
                count++;
                sum += k;
            }
        }

        System.out.printf("%d %.1f", sum, (double) sum / count);
    }
}