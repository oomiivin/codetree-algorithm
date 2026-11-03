import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        double sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            sum += Double.parseDouble(st.nextToken());
        }

        double avg = sum / n;
        System.out.printf("%.1f\n", avg);
        if(avg >= 4.0) System.out.print("Perfect");
        else if(avg >= 3.0) System.out.print("Good");
        else System.out.print("Poor");
    }
}