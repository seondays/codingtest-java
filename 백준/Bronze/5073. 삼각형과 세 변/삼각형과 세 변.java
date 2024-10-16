import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int one;
        int two;
        int three;

        while (true) {
            int[] triangle = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf)
                    .sorted()
                    .toArray();

            one = triangle[0];
            two = triangle[1];
            three = triangle[2];

            if (one == 0 && two == 0 && three == 0) {
                return;
            }

            if (three >= one + two) {
                System.out.println("Invalid");
                continue;
            }
            if (one == two && two == three) {
                System.out.println("Equilateral");
                continue;
            }
            if (one == two || two == three || one == three) {
                System.out.println("Isosceles");
                continue;
            }
            if (one != two && one != three) {
                System.out.println("Scalene");
                continue;
            }
        }
    }
}
