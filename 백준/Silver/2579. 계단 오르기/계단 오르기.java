import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] stairs = new int[301];
        int[] dp = new int[301];

        for (int i = 0; i < n; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        if (n == 0) {
            System.out.println(0);
            return;
        }

        dp[0] = stairs[0];
        dp[1] = stairs[1] + dp[0];
        dp[2] = Math.max(stairs[2] + stairs[1], stairs[2] + dp[0]);

        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(stairs[i] + dp[i - 2], stairs[i] + dp[i - 3] + stairs[i - 1]);
        }
        System.out.println(dp[n - 1]);
    }
}
