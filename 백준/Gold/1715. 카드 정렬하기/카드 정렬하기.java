import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int result = 0;

        for (int i = 0; i < count; i++) {
            queue.offer(Integer.parseInt(br.readLine()));
        }

        while(queue.size() > 1) {
            int first = queue.poll();
            int second = queue.poll();
            int sum = first + second;
            result += sum;
            queue.offer(sum);
        }
        System.out.println(result);
    }
}
