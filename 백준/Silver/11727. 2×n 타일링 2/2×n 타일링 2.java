import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] memory;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        memory = new int[1001];
        memory[1] = 1;
        memory[2] = 3;
        System.out.println(dp(n));
    }

    static int dp(int n) {
        if (memory[n] > 0) {
            return memory[n];
        }
        memory[n] = (dp(n - 1) + 2 * dp(n - 2)) % 10007;
        return memory[n];
    }
}
