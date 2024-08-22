import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int friendCount = Integer.parseInt(br.readLine());
    int round = Integer.parseInt(br.readLine());

    Map<Integer, Set<Integer>> graph = new HashMap<>();

    for (int i = 1; i <= friendCount; i++) {
      graph.put(i, new HashSet<>());
    }

    for (int i = 0; i < round; i++) {
      st = new StringTokenizer(br.readLine());

      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());

      graph.computeIfAbsent(start, k -> new HashSet<>()).add(end);
      graph.computeIfAbsent(end, k -> new HashSet<>()).add(start);
    }

    Set<Integer> visit = new HashSet<>();

    dfs(graph, 1, visit, 0);

    System.out.println(visit.size() - 1);
  }

  public static void dfs(Map<Integer, Set<Integer>> graph, int start, Set<Integer> visit,
      int depth) {
    if (depth > 2) return;
    visit.add(start);
    for (int friend : graph.get(start)) {
      dfs(graph, friend, visit, depth + 1);
    }
  }
}
