import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[][] matrix = new int[n][n];

    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int[] inner = new int[n];
      for(int j = 0; j < n; j++) {
        int element = Integer.parseInt(st.nextToken());
        inner[j] = element;
      }
      matrix[i] = inner;
    }
    // 경유지
    for (int i = 0; i < n; i++) {
      // 시작
      for (int j = 0; j < n; j++) {
        // 끝
        for (int k = 0; k < n; k++) {
          if(matrix[j][i] == 1 && matrix[i][k] == 1) {
            matrix[j][k] = 1;
          }
        }
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }
  }
}
