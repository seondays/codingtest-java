import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[91];
        dp[0] = 0;
        dp[1] = 1;

        System.out.println(fib(n,dp));
    }

    public static long fib(int n, long[] dp) {
        if (n == 1) {
            return 1;
        }
        if (n == 0) {
            return 0;
        }
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
