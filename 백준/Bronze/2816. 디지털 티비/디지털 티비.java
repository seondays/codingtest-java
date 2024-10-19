import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        String[] list = new String[count];
        List<Integer> result = new ArrayList<>();
        int index = 0;

        for (int i = 0; i < count; i++) {
            list[i] = br.readLine();
        }

        while (true) {
            if (list[index].equals("KBS1")) {
                break;
            }
            index++;
            result.add(1);
        }

        for (; index > 0; index--) {
            String tmp = list[index];
            list[index] = list[index - 1];
            list[index - 1] = tmp;
            result.add(4);
        }

        while (true) {
            if (list[index].equals("KBS2")) {
                break;
            }
            index++;
            result.add(1);
        }

        for (; index > 1; index--) {
            String tmp = list[index];
            list[index] = list[index - 1];
            list[index - 1] = tmp;
            result.add(4);
        }

        result.forEach(System.out::print);
    }
}
