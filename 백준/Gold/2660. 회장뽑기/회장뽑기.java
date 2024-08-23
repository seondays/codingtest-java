import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int n = Integer.parseInt(br.readLine());
    int[][] graph = new int[n][n];
    final int INF = 100000000;
    for (int i = 0; i < n; i++) {
      Arrays.fill(graph[i], INF);
      graph[i][i] = 0;
    }
    int start;
    int end;

    while (true) {
      st = new StringTokenizer(br.readLine());
      start = Integer.parseInt(st.nextToken());
      end = Integer.parseInt(st.nextToken());
      if (start == -1) {
        break;
      }
      graph[start - 1][end - 1] = 1;
      graph[end - 1][start - 1] = 1;
    }

    fwa(graph, n);

    int[] score = new int[n];
    int minScore = INF;

    for (int i = 0; i < n; i++) {
      int maxDist = 0;
      for (int j = 0; j < n; j++) {
        if (graph[i][j] < INF) {
          maxDist = Math.max(maxDist, graph[i][j]);
        }
      }
      score[i] = maxDist;
      minScore = Math.min(minScore, score[i]);
    }

    StringBuilder sb = new StringBuilder();
    int count = 0;
    for (int i = 0; i < n; i++) {
      if (score[i] == minScore) {
        sb.append(i + 1).append(" ");
        count++;
      }
    }
    System.out.println(minScore + " " + count);
    System.out.println(sb);
  }

  public static void fwa(int[][] graph, int n) {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        for (int k = 0; k < n; k++) {
          if (graph[j][k] > graph[j][i] + graph[i][k]) {
            graph[j][k] = graph[j][i] + graph[i][k];
          }
        }
      }
    }
  }
}
