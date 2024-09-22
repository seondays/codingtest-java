import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        };
        PriorityQueue<Integer> queue = new PriorityQueue<>(com);

        for (int i = 0; i < count; i++) {
            String[] lines = br.readLine().split(" ");
            for (int j = 0; j < lines.length; j++) {
                queue.offer(Integer.parseInt(lines[j]));
            }
        }

        for (int i = 0; i < count - 1; i++) {
            queue.poll();
        }

        System.out.println(queue.poll());
    }
}
