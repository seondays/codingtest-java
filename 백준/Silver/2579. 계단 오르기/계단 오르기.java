import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int[] stairs = new int[count];
        
        for (int i = 0; i < count; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }
        
        System.out.println(solution(count, stairs));
    }
    
    public static int solution(int n, int[] stairs) {
        if (n == 1) return stairs[0];
        if (n == 2) return stairs[0] + stairs[1];
        
        int[] dp = new int[n];
        dp[0] = stairs[0];
        dp[1] = stairs[0] + stairs[1];
        dp[2] = Math.max(stairs[0] + stairs[2], stairs[1] + stairs[2]);
        
        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + stairs[i], dp[i - 3] + stairs[i - 1] + stairs[i]);
        }
        
        return dp[n - 1];
    }
}
