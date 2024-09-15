import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (Math.abs(o1) > Math.abs(o2)) {
                    return 1;
                } else if (Math.abs(o1) == Math.abs(o2)) {
                    return o1 - o2;
                } else {
                    return -1;
                }
            }
        };

        PriorityQueue<Integer> pq = new PriorityQueue<>(comparator);

        for (int i = 0; i < count; i++) {
            int now = Integer.parseInt(br.readLine());
            if (now == 0) {
                Integer top = pq.poll();
                if (top == null) {
                    System.out.println(0);
                } else {
                    System.out.println(top);
                }
            } else {
                pq.offer(now);
            }
        }
    }
}
