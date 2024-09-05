import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[][][] tetromino = {
            // I 모양 (2가지)
            {{0, 0}, {0, 1}, {0, 2}, {0, 3}},
            {{0, 0}, {1, 0}, {2, 0}, {3, 0}},

            // O 모양 (1가지)
            {{0, 0}, {0, 1}, {1, 0}, {1, 1}},

            // T 모양 (4가지)
            {{0, 0}, {0, 1}, {0, 2}, {1, 1}},
            {{0, 0}, {1, 0}, {2, 0}, {1, 1}},
            {{0, 1}, {1, 0}, {1, 1}, {1, 2}},
            {{1, 0}, {0, 1}, {1, 1}, {2, 1}},

            // L 모양 (4가지)
            {{0, 0}, {1, 0}, {2, 0}, {2, 1}},
            {{0, 0}, {0, 1}, {0, 2}, {1, 0}},
            {{0, 0}, {0, 1}, {1, 1}, {2, 1}},
            {{1, 0}, {1, 1}, {1, 2}, {0, 2}},

            // J 모양 (L의 대칭, 4가지)
            {{0, 1}, {1, 1}, {2, 1}, {2, 0}},
            {{0, 0}, {1, 0}, {1, 1}, {1, 2}},
            {{0, 0}, {0, 1}, {1, 0}, {2, 0}},
            {{0, 0}, {0, 1}, {0, 2}, {1, 2}},

            // S 모양 (2가지)
            {{0, 1}, {0, 2}, {1, 0}, {1, 1}},
            {{0, 0}, {1, 0}, {1, 1}, {2, 1}},

            // Z 모양 (S의 대칭, 2가지)
            {{0, 0}, {0, 1}, {1, 1}, {1, 2}},
            {{1, 0}, {1, 1}, {0, 1}, {2, 0}}
    };

    private static int[][] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int result = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                result = Math.max(result,solution(i,j,m,n));
            }
        }
        System.out.println(result);
    }

    public static int solution(int x, int y, int m, int n) {
        int result = 0;

        for (int i = 0; i < 19; i++) {
            int sum = 0;
            for (int j = 0; j < 4; j++) {
                int[] now = tetromino[i][j];
                int nextX = x + now[0];
                int nextY = y + now[1];

                if(nextX >= n || nextY >= m) {
                    continue;
                }
                sum += graph[nextX][nextY];
            }
            result = Math.max(result, sum);
        }
        return result;
    }
}
