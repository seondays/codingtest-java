import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static Map<Integer, ArrayList<Integer>> graph;
    static boolean[] visit;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int computer = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        graph = new HashMap<>();

        for (int i = 1; i <= computer; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        visit = new boolean[computer + 1];

        dfs(1);

        System.out.println(result);
    }

    public static void dfs(int n) {
        // 함수 실행 시 방문 처리
        visit[n] = true;

        // 현재 컴퓨터와 연결된 list를 가져옴
        ArrayList<Integer> link = graph.get(n);

        // 연결된 컴퓨터에 방문하지 않았다면 이동
        for (int computer : link) {
            if (!visit[computer]) {
                dfs(computer);
                result++;
            }
        }
    }
}
