import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[][] graph = new String[n][n];

        for (int i = 0; i < n; i++) {
            String[] row = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                graph[i][j] = row[j];
            }
        }

        int row = 0;
        int col = 0;
        int tmp = 0;

        for (int i = 0; i <= n; i++) {
            if (tmp >= 2) {
                row++;
            }
            if (i == n) {
                break;
            }
            tmp = 0;
            for (int j = 0; j < n; j++) {
                if (graph[i][j].equals(".")) {
                    tmp++;
                } else {
                    if (tmp >= 2) {
                        row++;
                    }
                    tmp = 0;
                }
            }
        }
        System.out.print(row + " ");

        tmp = 0;
        for (int i = 0; i <= n; i++) {
            if (tmp >= 2) {
                col++;
            }
            if (i == n) {
                break;
            }
            tmp = 0;
            for (int j = 0; j < n; j++) {
                if (graph[j][i].equals(".")) {
                    tmp++;
                } else {
                    if (tmp >= 2) {
                        col++;
                    }
                    tmp = 0;
                }
            }
        }
        System.out.println(col);
    }
}
