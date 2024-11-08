import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] memory;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if(n == 0) {
            System.out.println(0);
            return;
        }

        memory = new int[46];
        memory[1] = 1;
        memory[2] = 1;
        System.out.println(dp(n));
    }

    static int dp(int n) {
        if (memory[n] > 0 && n > 0) {
            return memory[n];
        }
        memory[n] = dp(n - 1) + dp(n - 2);
        return memory[n];
    }
}
