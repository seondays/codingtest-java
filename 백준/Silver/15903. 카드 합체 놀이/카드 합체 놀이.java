import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] condition = line.split(" ");
        int n = Integer.parseInt(condition[0]);
        int m = Integer.parseInt(condition[1]);

        line = br.readLine();
        String[] numbers = line.split(" ");
        PriorityQueue<Long> queue = new PriorityQueue<>();

        for (String number : numbers) {
            queue.offer(Long.parseLong(number));
        }

        for (int i = 0; i < m; i++) {
            long first = queue.poll();
            long second = queue.poll();

            long result = first + second;
            queue.offer(result);
            queue.offer(result);
        }
        System.out.println(queue.stream().mapToLong(Long::longValue).sum());
    }
}
