import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    
    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());

      int first = Integer.parseInt(st.nextToken());
      int second = Integer.parseInt(st.nextToken());

      graph.get(first).add(second);
    }

    boolean[] visit;
    int[] computers = new int[n + 1];

    for (int i = 1; i <= n; i++) {
      visit = new boolean[n + 1];
      dfs(graph, i, visit, computers);
    }

    int maxValue = Integer.MIN_VALUE;
    StringBuffer sb = new StringBuffer();

    for (int i = 1; i < computers.length; i++) {
      if (computers[i] >= maxValue) {
        maxValue = computers[i];
      }
    }

    for (int i = 1; i < computers.length; i++) {
      if (computers[i] == maxValue) {
        sb.append(i).append(" ");
      }
    }
    System.out.println(sb.toString());
  }

  public static void dfs(ArrayList<ArrayList<Integer>> graph, int start, boolean[] visit, int[] computers) {
    visit[start] = true;

    for (int i : graph.get(start)) {
      if (!visit[i]) {
        computers[i]++;
        dfs(graph, i, visit, computers);
      }
    }
  }
}
