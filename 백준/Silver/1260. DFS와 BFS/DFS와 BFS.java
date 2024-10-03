import java.util.*;
import java.io.*;

public class Main {

    private static Map<Integer, List<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        graph = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<Integer>());
        }

        for (int i = 0; i < m; i++) {
            int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf)
                    .toArray();
            graph.get(line[0]).add(line[1]);
            graph.get(line[1]).add(line[0]);
        }

        for (int key : graph.keySet()) {
            Collections.sort(graph.get(key));
        }
        int[] visit = new int[n + 1];

        // DFS
        dfs(start, visit);
        System.out.println();
        visit = new int[n + 1];
        bfs(start, visit);

    }

    private static void dfs(int vertex, int[] visit) {
        if (visit[vertex] != 0) {
            return;
        }
        visit[vertex] = 1;
        System.out.print(vertex + " ");
        for (int n : graph.get(vertex)) {
            if (visit[n] == 0) {
                dfs(n, visit);
            }
        }
    }

    private static void bfs(int vertex, int[] visit) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(vertex);
        visit[vertex] = 1;
        System.out.print(vertex + " ");

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int n : graph.get(now)) {
                if (visit[n] == 0) {
                    visit[n] = 1;
                    System.out.print(n + " ");
                    queue.offer(n);
                }
            }
        }
    }
}
