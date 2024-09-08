import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int[] sequence;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        sequence = new int[m + 1];

        solution(1, 1);
    }

    static void solution(int depth, int now) {
        if (depth - 1 == m) {
            StringBuffer sb = new StringBuffer();
            for (int i = 1; i <= m; i++) {
                sb.append(sequence[i]).append(" ");
            }
            System.out.println(sb);
            return;
        }

        for (int i = now; i < n + 1; i++) {
            if (sequence[depth - 1] <= i) {
                sequence[depth] = i;
                solution(depth + 1, now);
            }
        }
    }
}
