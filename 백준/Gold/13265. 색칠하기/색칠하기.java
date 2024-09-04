import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static int[] colored;
    private static List<List<Integer>> graph;

    public static void main(String[] args) throws IOException {
        // dfs로 사이클이 있는 경우 impossible
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());
            int dot = Integer.parseInt(st.nextToken());
            int line = Integer.parseInt(st.nextToken());

            // 그래프 초기화
            graph = new ArrayList<>();
            for (int j = 0; j <= dot; j++) {
                graph.add(new ArrayList<>());
            }

            // 인접 리스트 생성
            for (int j = 0; j < line; j++) {
                st = new StringTokenizer(br.readLine());
                int first = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                graph.get(first).add(end);
                graph.get(end).add(first);
            }

            colored = new int[dot + 1];
            Arrays.fill(colored, -1);

            boolean result = true;
            for (int k = 1; k <= dot; k++) {
                if (colored[k] == -1) {
                    if (!dfs(k, 0)) {
                        result = false;
                        break;
                    }
                }
            }

            if (result) {
                System.out.println("possible");
            } else {
                System.out.println("impossible");
            }
        }
    }

    public static boolean dfs(int dot, int color) {
        if (colored[dot] != -1) {
            return colored[dot] == color;
        }

        colored[dot] = color;

        for (int neighbor : graph.get(dot)) {
            if (!dfs(neighbor, 1 - color)) {
                return false;
            }
        }
        return true;
    }
}
