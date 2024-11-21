import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    static List<Integer> result;
    static int[] tall;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        tall = new int[9];

        for (int i = 0; i < 9; i++) {
            tall[i] = Integer.parseInt(br.readLine());
        }
        result = new ArrayList<>();

        recursion(0, 0);
    }

    static void recursion(int length, int index) {
        // base
        if (length == 7) {
            if (result.stream().mapToInt(Integer::valueOf).sum() == 100) {
                Collections.sort(result);
                for (int i = 0; i < 7; i++) {
                    System.out.println(result.get(i));
                }
                System.exit(0);
            }
            return;
        }

        for (int i = index; i < 9; i++) {
            result.add(tall[i]);
            recursion(length + 1, index + 1);
            result.remove(result.size() - 1);
        }

    }
}
