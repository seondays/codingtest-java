import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static char[][] graph;
    static char[][] colorBlindGraph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        graph = new char[n][n];
        colorBlindGraph = new char[n][n];

        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            for (int j = 0; j < n; j++) {
                graph[i][j] = row.charAt(j);
                if (row.charAt(j) == 'R') {
                    colorBlindGraph[i][j] = 'G';
                } else {
                    colorBlindGraph[i][j] = row.charAt(j);
                }
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(graph[i][j] != '.') {
                    bfs(i,j,n,graph[i][j],graph);
                    result++;
                }
            }
        }
        System.out.print(result+" ");

        result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(colorBlindGraph[i][j] != '.') {
                    bfs(i,j,n,colorBlindGraph[i][j],colorBlindGraph);
                    result++;
                }
            }
        }
        System.out.println(result);
    }

    public static void bfs(int x, int y, int n, char color, char[][] graph) {
        int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();
        graph[x][y] = '.';
        queue.add(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] position = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = position[0] + direction[i][0];
                int nextY = position[1] + direction[i][1];

                if (nextY < 0 || nextX < 0 || nextX >= n || nextY >= n) {
                    continue;
                }

                if (graph[nextX][nextY] == color) {
                    graph[nextX][nextY] = '.';
                    queue.add(new int[]{nextX, nextY});
                }
            }
        }
    }
}
