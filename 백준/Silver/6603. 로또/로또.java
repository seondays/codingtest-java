import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static final int max = 6;
    private static int[] numbers;
    private static boolean[] visit;
    private static int[] result;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while (!(line = br.readLine()).equals("0")) {
            int[] test = Arrays.stream(line.split(" ")).mapToInt(Integer::valueOf).toArray();

            int n = test[0];
            numbers = Arrays.copyOfRange(test, 1, test.length);
            visit = new boolean[n];
            result = new int[6];

            backtrack(0);
            System.out.println();
        }
    }

    public static void backtrack(int index) {
        if (index == max) {
            for (int i = 0; i < max; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < numbers.length; i++) {
            if (index > 0 && result[index - 1] > numbers[i]) {
                continue;
            }
            if (!visit[i]) {
                visit[i] = true;
                result[index] = numbers[i];
                backtrack(index + 1);
                visit[i] = false;
            }
        }
    }
}
