import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
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
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      graph.get(start).add(end);
      graph.get(end).add(start);
    }

    int[] result = new int[n + 1];

    for (int i = 1; i <= n; i++) {
      int[] distance = new int[n + 1];
      Arrays.fill(distance, -1);
      result[i] = bfs(i, graph, distance);
    }

    int minValue = Integer.MAX_VALUE;
    int minIndex = -1;

    for (int i = 1; i <= n; i++) {
      if (result[i] < minValue) {
        minValue = result[i];
        minIndex = i;
      }
    }

    System.out.println(minIndex);
  }

  public static int bfs(int start, ArrayList<ArrayList<Integer>> graph, int[] distance) {
    Queue<Integer> queue = new LinkedList<>();
    int result = 0;

    queue.add(start);
    distance[start] = 0;

    while (!queue.isEmpty()) {
      int now = queue.poll();
      for (int next : graph.get(now)) {
        if (distance[next] == -1) {
          distance[next] = distance[now] + 1;
          result += distance[next];
          queue.offer(next);
        }
      }
    }
    return result;
  }
}
