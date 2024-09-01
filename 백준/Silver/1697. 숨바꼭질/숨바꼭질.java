import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        if (start == end) {
            System.out.println(0);
            return;
        }

        Queue<int[]> queue = new LinkedList<>();
        boolean[] visit = new boolean[100001];
        queue.add(new int[]{start, 0});
        visit[start] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int position = now[0];
            int time = now[1];

            if (position == end) {
                System.out.println(time);
                break;
            }

            int[] nextPositions = {position - 1, position + 1, position * 2};
            for (int next : nextPositions) {
                if (next >= 0 && next <= 100000 && !visit[next]) {
                    visit[next] = true;
                    queue.add(new int[]{next, time + 1});
                }
            }
        }
    }
}