import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        char[][] graph = new char[m][n];
        for (int i = 0; i < m; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                graph[i][j] = line.charAt(j);
            }
        }

        // 불이 퍼지는 그래프 설정
        int[][] fireGraph = new int[m][n];
        int[][] jihoonGraph = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == '#') {
                    fireGraph[i][j] = -1;
                    jihoonGraph[i][j] = -1;
                }
            }
        }

        //불이 퍼지는 시간을 담는다
        Queue<int[]> fireQueue = new LinkedList<>();
        Queue<int[]> jihoonQueue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 'F') {
                    fireGraph[i][j] = 1;
                    fireQueue.add(new int[]{i, j});
                }
                if (graph[i][j] == 'J') {
                    jihoonGraph[i][j] = 1;
                    jihoonQueue.add(new int[]{i, j});
                    if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
                        System.out.println(1);
                        return;
                    }
                }
            }
        }

        //불이 먼저 퍼진다.
        int[][] direction = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while (!fireQueue.isEmpty()) {
            int[] position = fireQueue.poll();
            for (int i = 0; i < 4; i++) {
                int x = position[0] + direction[i][0];
                int y = position[1] + direction[i][1];

                if (x < 0 || y < 0 || x >= m || y >= n || fireGraph[x][y] == -1) {
                    continue;
                }
                if (fireGraph[x][y] == 0) {
                    fireGraph[x][y] = fireGraph[position[0]][position[1]] + 1;
                    fireQueue.add(new int[]{x, y});
                }
            }
        }

        // 지훈이의 이동을 계산한다
        while (!jihoonQueue.isEmpty()) {
            int[] position = jihoonQueue.poll();
            for (int i = 0; i < 4; i++) {
                int x = position[0] + direction[i][0];
                int y = position[1] + direction[i][1];

                if (x < 0 || y < 0 || x >= m || y >= n) {
                    continue;
                }

                if (jihoonGraph[x][y] == 0 && (fireGraph[x][y] == 0 || jihoonGraph[position[0]][position[1]] + 1 < fireGraph[x][y])) {
                    jihoonGraph[x][y] = jihoonGraph[position[0]][position[1]] + 1;
                    jihoonQueue.add(new int[]{x, y});

                    if (x == 0 || y == 0 || x == m - 1 || y == n - 1) {
                        System.out.println(jihoonGraph[x][y]);
                        return;
                    }
                }
            }
        }
        System.out.println("IMPOSSIBLE");
    }
}

