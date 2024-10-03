import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int start = input[0];
        int end = input[1];

        boolean[] visit = new boolean[100001];
        int[] path = new int[100001];
        bfs(start, end, visit, path);
    }

    private static void bfs(int start, int end, boolean[] visit, int[] path) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start, 0});

        while (!queue.isEmpty()) {
            int[] info = queue.poll();
            int position = info[0];
            int time = info[1];

            if (position == end) {
                System.out.println(time);
                int[] print = new int[time + 1];
                print[0] = position;
                for (int i = 1; i <= time; i++) {
                    print[i] = path[position];
                    position = path[position];
                }
                for (int i = time; i >= 0; i--) {
                    System.out.print(print[i] + " ");
                }
                return;
            }

            int[] direction = new int[]{position + 1, position - 1, position * 2};
            for (int i = 0; i < 3; i++) {
                if (direction[i] < 0 || direction[i] > 100000 || visit[direction[i]]) {
                    continue;
                }
                visit[direction[i]] = true;
                queue.offer(new int[]{direction[i], time + 1});
                path[direction[i]] = position;
            }
        }
    }
}
