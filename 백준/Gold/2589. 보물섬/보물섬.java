import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static char[][] graph;
    static boolean[][] visit;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new char[n][m];
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            graph[i] = br.readLine().toCharArray();
        }
        int maxDistance = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 'L') {
                    maxDistance = Math.max(maxDistance, bfs(i, j));
                    visit = new boolean[n][m];
                }
            }
        }
        System.out.println(maxDistance);
    }

    static int bfs(int x, int y) {
        int result = 0;
        int[][] times = new int[n][m];
        int[][] direction = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visit[x][y] = true;

        while (!queue.isEmpty()) {
            int[] position = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextx = position[0] + direction[i][0];
                int nexty = position[1] + direction[i][1];

                if (nextx < 0 || nexty < 0 || nextx >= n || nexty >= m) {
                    continue;
                }

                if (!visit[nextx][nexty] && graph[nextx][nexty] == 'L') {
                    visit[nextx][nexty] = true;
                    times[nextx][nexty] = times[position[0]][position[1]] + 1;
                    queue.add(new int[]{nextx, nexty});
                    if (result < times[nextx][nexty]) {
                        result = times[nextx][nexty];
                    }
                }
            }
        }
        return result;
    }

}
