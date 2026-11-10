import java.util.*;
import java.io.*;

public class Main {

    static int n, m, q;
    static int[][] building;

    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        building = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++)
                building[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());

            int sr = Integer.parseInt(st.nextToken()) - 1;
            int sc = Integer.parseInt(st.nextToken()) - 1;
            int er = Integer.parseInt(st.nextToken()) - 1;
            int ec = Integer.parseInt(st.nextToken()) - 1;

            wind(sr, sc, er, ec);
            change(sr, sc, er, ec);
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                System.out.print(building[i][j] + " ");
            }
            System.out.println();
        } 
    }

    public static void wind(int sr, int sc, int er, int ec) {
        int cur = building[sr][sc];
        int cr = sr, cc = sc;
        char dir = 'R';
        int T = (ec - sc + 1) * 2 + (er - sr - 1) * 2;

        while(T-- > 0) {
            int nr = cr, nc = cc;

            if(dir == 'R') {
                nc++;

                if(nc > ec) {
                    dir = 'D';
                    nr = cr + 1; nc = cc;
                }
            }
            else if(dir == 'D') {
                nr++;

                if(nr > er) {
                    dir = 'L';
                    nr = cr; nc = cc - 1;
                }
            }
            else if(dir == 'L') {
                nc--;

                if(nc < sc) {
                    dir = 'U';
                    nr = cr - 1; nc = cc;
                }
            }
            else if(dir == 'U') {
                nr--;

                if(nr < sr) {
                    dir = 'R';
                    nr = cr; nc = cc + 1;
                }
            }

            int tmp = building[nr][nc];
            building[nr][nc] = cur;
            cur = tmp;
            cr = nr; cc = nc;
        }
    }

    public static void change(int sr, int sc, int er, int ec) {
        int[][] newBuilding = new int[n][m];

        for(int i = 0; i < n; i++) {
            newBuilding[i] = Arrays.copyOf(building[i], m);
        }

        for(int i = sr; i <= er; i++) {
            for(int j = sc; j <= ec; j++) {
                int sum = building[i][j];
                int count = 1;

                for(int d = 0; d < 4; d++) {
                    int nr = i + dr[d], nc = j + dc[d];

                    if(nr >= 0 && nr < n && nc >= 0 && nc < m) {
                        sum += building[nr][nc];
                        count++;
                    }
                }

                newBuilding[i][j] = sum / count;
            }
        }

        building = newBuilding;
    }
}