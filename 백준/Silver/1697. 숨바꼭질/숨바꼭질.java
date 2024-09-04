import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        visit = new boolean[100001];
            bfs(start, end);
    }

    public static void bfs(int start, int end) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, 0});
        visit[start] = true;

        while (!queue.isEmpty()) {
            int[] info = queue.poll();
            int position = info[0];
            int depth = info[1];

            if (position == end) {
                System.out.println(depth);
                return;
            }

            // 경우의 수 만들기
            int[] nextPosition = {position - 1, position + 1, position * 2};
            for (int i = 0; i < 3; i++) {
                if (nextPosition[i] < 0 || nextPosition[i] > 100000 || visit[nextPosition[i]]) {
                    continue;
                }
                visit[nextPosition[i]] = true;
                queue.add(new int[]{nextPosition[i], depth + 1});
            }
        }

    }
}
