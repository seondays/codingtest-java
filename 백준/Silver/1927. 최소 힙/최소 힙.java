import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        for(int i = 0; i < count; i++) {
            int n = Integer.parseInt(br.readLine());
            
            if(n == 0) {
                if(queue.isEmpty()) {
                    System.out.println(0);
                }
                else {
                    System.out.println(queue.poll());
                }
            } else {
                queue.offer(n);
            }
        }
    }
}