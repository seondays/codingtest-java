import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = line[0];
        int money = line[1];
        
        int[] coins = new int[n];
        int result = 0;
        
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        
        for (int i = coins.length - 1; i > -1; i--) {
            result += money / coins[i];
            money %= coins[i];
        }
        
        System.out.println(result);
    }
}