import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<int[]> queue = new LinkedList<>();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] graph = new int[m][n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 출발점 토마토 queue에 담기
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        int result = solution(graph, n, m, queue);

        // 모든 칸을 탐색하여 익지 않은 토마토가 있는지 확인
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        if (result == 0) {
            System.out.println(0);
        } else {
            System.out.println(result - 1);
        }
    }

    public static int solution(int[][] graph, int n, int m, Queue<int[]> queue) {
        int[][] direction = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int result = 0;

        while (!queue.isEmpty()) {
            int[] hold = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = hold[0] + direction[i][0];
                int nextY = hold[1] + direction[i][1];

                if (nextX < 0 || nextY < 0 || nextX >= m || nextY >= n) {
                    continue;
                }

                if (graph[nextX][nextY] == -1) {
                    continue;
                }

                if (graph[nextX][nextY] == 0) {
                    graph[nextX][nextY] = graph[hold[0]][hold[1]] + 1;
                    result = Math.max(result, graph[nextX][nextY]);
                    queue.add(new int[]{nextX, nextY});
                }
            }
        }
        return result;
    }
}
