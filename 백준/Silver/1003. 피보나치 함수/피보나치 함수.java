import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            long[] zero = new long[41];
            long[] one = new long[41];
            long[] dp = new long[41];
            int target = Integer.parseInt(br.readLine());

            zero[0] = 1;
            one[0] = 0;

            zero[1] = 0;
            one[1] = 1;

            for (int j = 2; j <= target; j++) {
                zero[j] = zero[j - 1] + zero[j - 2];
                one[j] = one[j - 1] + one[j - 2];
            }
            System.out.println(zero[target] + " " + one[target]);
        }
    }
}
