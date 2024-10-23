import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> tall;

        for (int i = 0; i < n; i++) {
            int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf)
                    .toArray();
            tall = new LinkedList<>();
            int result = 0;

            for (int j = 1; j < array.length; j++) {
                tall.add(array[j]);
            }

            for (int j = 1; j < 20; j++) {
                int position = 0;
                int now = tall.get(j);

                if (tall.get(j - 1) < now) {
                    continue;
                }

                while(position < 20 && tall.get(position) < now) {
                    position++;
                }

                tall.remove(j);
                result += j - position;
                tall.add(position, now);
            }

            System.out.println(array[0] + " " + result);
        }

    }
}
