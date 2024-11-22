import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static char[][] graph;
    static boolean[] visit;
    static int r;
    static int c;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        graph = new char[r][c];
        visit = new boolean[26];

        for (int i = 0; i < r; i++) {
            graph[i] = br.readLine().toCharArray();
        }

        dfs(0, 0, 1);
        System.out.println(max);
    }

    static void dfs(int x, int y, int step) {
        int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        visit[graph[x][y]  - 'A'] = true;

        max = Math.max(step, max);

        for (int i = 0; i < 4; i++) {
            int nextX = direction[i][0] + x;
            int nextY = direction[i][1] + y;

            if (nextX < 0 || nextY < 0 || nextX >= r || nextY >= c) {
                continue;
            }

            if (!visit[graph[nextX][nextY] - 'A']) {

                dfs(nextX, nextY, step + 1);

                visit[graph[nextX][nextY]  - 'A'] = false;
            }
        }
    }
}
