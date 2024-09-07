import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    private static int n;
    private static int m;
    private static boolean[] visit;
    private static List<Integer> sequence = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 방문 확인 배열 초기화
        visit = new boolean[n+1];
        solution(0);
    }

    public static void solution(int start) {
        // 종료 조건 설정 -> 길이 m이 되면 반복을 마치고 print
        if (start == m) {
            System.out.println(sequence.stream().map(String::valueOf).collect(Collectors.joining(" ")));
            return;
        }

        // 내부 루트 반복
        for (int i = 1; i < n+1; i++) {
            if(!visit[i]) {
                visit[i] = true;
                sequence.add(i);
                solution(start + 1);
                sequence.remove(sequence.size()-1);
                visit[i] = false;
            }
        }
    }
}
