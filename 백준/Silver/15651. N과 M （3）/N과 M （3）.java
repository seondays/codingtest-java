import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int[] sequence;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        sequence = new int[m];

        solution(0);
        System.out.print(sb);
    }

    static void solution(int depth) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(sequence[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 1; i <= n; i++) {
            sequence[depth] = i;
            solution(depth + 1);
        }
    }
}