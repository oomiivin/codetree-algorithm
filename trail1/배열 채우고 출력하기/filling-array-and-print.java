import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = new char[10];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 10; i++) arr[i] = st.nextToken().charAt(0);
        for(int i = 9; i >= 0; i--) System.out.print(arr[i]);
    }
}