import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String target = br.readLine();
        String[] splitMinus = target.split("-");
        int[] result = new int[splitMinus.length];

        for (int i = 0; i < splitMinus.length; i++) {
            String[] splitPlus = splitMinus[i].split("\\+");
            int sum = Arrays.stream(splitPlus).mapToInt(Integer::parseInt).sum();
            result[i] = sum;
        }

        System.out.println(Arrays.stream(result).reduce((a,b) -> a - b).getAsInt());
    }
}
