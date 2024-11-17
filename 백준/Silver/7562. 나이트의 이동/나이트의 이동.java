import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[][] graph;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int round = Integer.parseInt(br.readLine());

        for (int i = 0; i < round; i++) {
            int size = Integer.parseInt(br.readLine());
            graph = new int[size][size];
            visit = new boolean[size][size];

            int[] start = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf)
                    .toArray();
            int[] target = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf)
                    .toArray();

            if (start[0] == target[0] && start[1] == target[1]) {
                System.out.println(0);
                continue;
            }

            bfs(start);

            System.out.println(graph[target[0]][target[1]]);
        }
    }

    static void bfs(int[] start) {
        int[][] direction = {{2, 1}, {2, -1}, {1, -2}, {1, 2}, {-2, 1}, {-2, -1}, {-1, -2},
                {-1, 2}};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int[] position = queue.poll();
            for (int[] ints : direction) {
                int x = position[0] + ints[0];
                int y = position[1] + ints[1];

                if (x < 0 || y < 0 || x >= graph.length || y >= graph.length) {
                    continue;
                }
                if (!visit[x][y]) {
                    graph[x][y] = graph[position[0]][position[1]] + 1;
                    queue.add(new int[]{x, y});
                    visit[x][y] = true;
                }
            }
        }
    }
}
