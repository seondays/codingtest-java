import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

    static int n;
    static int m;
    static boolean[] visit;
    static List<Integer> seenSum = new ArrayList<>();
    static List<Integer> sequence = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visit = new boolean[n + 1];

        solution(0, 1);
    }

    static void solution(int depth, int start) {
        if (depth == m) {
            System.out.println(
                    sequence.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        }

        for (int i = start; i < n + 1; i++) {
            if (!visit[i]) {
                visit[i] = true;
                sequence.add(i);
                solution(depth + 1, i + 1);
                visit[i] = false;
                sequence.remove(sequence.size() - 1);
            }
        }
    }
}
