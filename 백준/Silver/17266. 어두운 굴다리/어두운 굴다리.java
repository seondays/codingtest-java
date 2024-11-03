import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    static int[] x;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        x = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();

        int lo = 0;
        int hi = n;

        while (lo + 1 < hi) {
            int mid = (lo + hi) / 2;
            if (!check(mid)) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        System.out.println(hi);
    }

    public static boolean check(int mid) {
        if (x[0] > mid) {
            return false;
        }

        int lastCovered = x[0] + mid;

        for (int i = 1; i < x.length; i++) {
            int left = x[i] - mid;
            int right = x[i] + mid;

            if (left > lastCovered) {
                return false;
            }
            lastCovered = right;
        }
        return lastCovered >= n;
    }
}
