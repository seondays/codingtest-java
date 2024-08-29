import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[][] graph = new int[r][c];

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(graph[i][j] == 1) {
                    solution(graph, result, new int[]{i,j}, r, c);
                }
            }
        }
        System.out.println(result.size());
        System.out.println(result.stream().max(Integer::compare).orElse(0));
    }
    
public static void solution(int[][] graph, List<Integer> result, int[] start, int r, int c) {
        Integer[][] direction = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
        Queue<Integer[]> queue = new LinkedList();
        queue.add(new Integer[]{start[0], start[1]});
        graph[start[0]][start[1]] = 0;
        int size = 0;

        while (!queue.isEmpty()) {
            size += 1;
            Integer[] origin = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = origin[0] + direction[i][0];
                int nextY = origin[1] + direction[i][1];

                if (!(0 <= nextX && nextX < r && 0 <= nextY && nextY < c)) {
                    continue;
                }

                if (graph[nextX][nextY] == 1) {
                    queue.add(new Integer[]{nextX, nextY});
                    graph[nextX][nextY] = 0;
                }
            }
        }
        result.add(size);
    }
}