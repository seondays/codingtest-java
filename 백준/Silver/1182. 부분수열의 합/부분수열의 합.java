import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static int n;
    private static int m;
    private static int[] numbers;
    private static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] condition = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf)
                .toArray();
        numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf)
                .toArray();
        n = condition[0];
        m = condition[1];
        result = 0;

        backtracking(0, 0);
        if(m == 0) {
            result--;
        }

        System.out.println(result);
    }

    private static void backtracking(int index, int sum) {
        if (index == numbers.length) {
            if (sum == m) {
                result++;
                return;
            }
            return;
        }

        backtracking(index + 1, numbers[index] + sum);

        backtracking(index + 1, sum);
    }
}
