import java.util.*;
import java.io.*;

public class Main {
   public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[5001];

        dp[0] = -1;
        dp[1] = -1;
        dp[2] = -1;
        dp[3] = 1;
        dp[4] = -1;
        dp[5] = 1;

        if(n < 6) {
            System.out.println(dp[n]);
            return;
        }

        for (int i = 6; i <= n; i++) {
            int option1 = dp[i - 3];
            int option2 = dp[i - 5];
            if (option1 == -1 && option2 == -1) {
                dp[i] = -1;
            }
            if (option1 * option2 < 0) {
                dp[i] = Math.max(option1, option2) + 1;
            }
            if (option1 > 0 && option2 > 0) {
                dp[i] = Math.min(option1, option2) + 1;
            }
        }

        System.out.println(dp[n]);
    }
}