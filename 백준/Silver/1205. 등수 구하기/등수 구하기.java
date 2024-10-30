import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int score = Integer.parseInt(st.nextToken());
        int rankCount = Integer.parseInt(st.nextToken());

        if (n == 0) {
            System.out.println(1);
            return;
        }

        int[] scores = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();

        int rank = 1;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (scores[i] > score) {
                rank++;
            } else if (scores[i] == score) {

            } else {
                // 비교하는 점수가 타겟 점수보다 작아지는 순간 반복문 탈출
                break;
            }
            count++;
        }

        if (count == rankCount) {
            System.out.println(-1);
        } else {
            System.out.println(rank);
        }
    }
}
