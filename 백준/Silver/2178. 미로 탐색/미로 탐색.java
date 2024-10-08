import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    private static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        graph = new int[line[0]][line[1]];

        for (int i = 0; i < line[0]; i++) {
            graph[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::valueOf).toArray();
        }
        bfs(line[0], line[1]);

    }

    private static void bfs(int x, int y) {
        int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        // bfs를 할 큐를 만든다
        Queue<int[]> queue = new LinkedList<>();
        // 큐에 초기값을 집어넣는다 (탐색의 시작점)
        queue.offer(new int[]{0, 0});

        // 방문을 기록할 리스트를 만든다
        boolean[][] visit = new boolean[101][101];

        // 큐에 원소가 존재하는 동안 탐색 반복
        while (!queue.isEmpty()) {
            int[] position = queue.poll();
            // 현재 위치에서 다음에 가능한 위치를 모두 큐에 추가하는 작업
            for (int i = 0; i < 4; i++) {
                int nx = position[0] + direction[i][0];
                int ny = position[1] + direction[i][1];

                // 맵을 벗어나는 위치인지 확인
                if (nx < 0 || ny < 0 || nx >= x || ny >= y) {
                    continue;
                }

                // 유효한 진행 방향인지 확인
                if (graph[nx][ny] == 1 && !visit[nx][ny]) {
                    visit[nx][ny] = true;
                    graph[nx][ny] = graph[position[0]][position[1]] + 1;
                    queue.offer(new int[]{nx,ny});
                }
            }
        }
        System.out.println(graph[x-1][y-1]);
    }

}
