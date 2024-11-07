import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int[] cards;
    static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        cards = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int m = Integer.parseInt(br.readLine());
        int[] targets = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf)
                .toArray();
        Arrays.sort(cards);

        for (int i = 0; i < m; i++) {
            bSearch(targets[i]);
        }
        System.out.println(sb);
    }

    static void bSearch(int target) {
        int x = lower(target);
        int y = upper(target);
        sb.append(y-x).append(" ");
    }

    static int lower(int target) {
        int lo = -1;
        int hi = cards.length;

        while (lo + 1 < hi) {
            int mid = (lo + hi) / 2;
            if (cards[mid] < target) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        return hi;
    }

    static int upper(int target) {
        int lo = -1;
        int hi = cards.length;

        while (lo + 1 < hi) {
            int mid = (lo + hi) / 2;
            if (cards[mid] <= target) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        return hi;
    }
}
