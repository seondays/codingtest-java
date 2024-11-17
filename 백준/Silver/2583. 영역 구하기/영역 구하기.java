import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

    static int m;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[][] graph = new boolean[n][m];

        // 좌표대로 영역 칠하기 (true로 바꿈)
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int j = x1; j < x2; j++) {
                for (int l = y1; l < y2; l++) {
                    graph[j][l] = true;
                }
            }
        }

        // 남은 공간 탐색
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(!graph[i][j]) {
                    result.add(bfs(graph, i, j));
                }
            }
        }
        System.out.println(result.size());
        String out = result.stream().sorted().map(String::valueOf).collect(Collectors.joining(" "));
        System.out.println(out);
    }

    static int bfs(boolean[][] graph, int startx, int starty) {
        int result = 1;
        int[][] direction = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{startx, starty});
        graph[startx][starty] = true;
        while (!queue.isEmpty()) {
            int[] position = queue.poll();
            int x = position[0];
            int y = position[1];

            for (int i = 0; i < 4; i++) {
                int x2 = direction[i][0] + x;
                int y2 = direction[i][1] + y;

                if (x2 < 0 || y2 < 0 || x2 >= n || y2 >= m) {
                    continue;
                }
                if (!graph[x2][y2]) {
                    graph[x2][y2] = true;
                    queue.add(new int[]{x2, y2});
                    result++;
                }
            }
        }
        return result;
    }
}
