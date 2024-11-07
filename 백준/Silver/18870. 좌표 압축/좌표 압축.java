import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Main {

    static int[] sorted;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] list = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        sorted = Arrays.stream(list).sorted().distinct().toArray();
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < n; i++) {
            sb.append(bSearch(list[i])).append(" ");
        }
        System.out.println(sb);
    }

    static int bSearch(int target) {
        int lo = -1;
        int hi = sorted.length;

        while (lo + 1 < hi) {
            int mid = (lo + hi) / 2;
            if (sorted[mid] < target) {
                lo = mid;
            } else if (sorted[mid] > target) {
                hi = mid;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
