import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] people = new int[n][2];
            for (int j = 0; j < n; j++) {
                people[j] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf)
                        .toArray();
            }
            Arrays.sort(people, (Comparator.comparingInt(o -> o[0])));
            int score = 0;
            int result = 1;
            for (int j = 0; j < n; j++) {
                if(j == 0) {
                    score = people[j][1];
                    continue;
                }
                int targetScore = people[j][1];
                if (score > targetScore) {
                    result++;
                }
                score = Math.min(people[j][1], score);
            }
            System.out.println(result);
        }
    }
}
