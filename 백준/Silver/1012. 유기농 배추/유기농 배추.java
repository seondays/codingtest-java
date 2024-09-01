import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int turnCount = Integer.parseInt(st.nextToken());
            int result = 0;

            map = new int[m][n];
            for (int j = 0; j < turnCount; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[x][y] = 1;
            }

            for (int k = 0; k < m; k++) {
                for (int l = 0; l < n; l++) {
                    if (map[k][l] == 1) {
                        bfs(k,l,m,n);
                        result++;
                    }
                }
            }
            System.out.println(result);
        }
    }

    public static void bfs(int x, int y, int m, int n) {
        int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();
        map[x][y] = 0;
        queue.add(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = now[0] + direction[i][0];
                int nextY = now[1] + direction[i][1];

                if (nextY < 0 || nextX < 0 || nextX >= m || nextY >= n) {
                    continue;
                }

                if (map[nextX][nextY] == 1) {
                    map[nextX][nextY] = 0;
                    queue.add(new int[]{nextX,nextY});
                }
            }
        }
    }
}
