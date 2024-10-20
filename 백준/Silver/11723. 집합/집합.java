import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int result = 0;

        for (int i = 0; i < count; i++) {
            String[] line = br.readLine().split(" ");
            String operation = line[0];
            int n = 0;

            if (line.length == 1) {
                if (operation.equals("all")) {
                    result = ((1 << 21) - 1);
                }
                if (operation.equals("empty")) {
                    result = 0;
                }
                continue;
            }

            n = Integer.parseInt(line[1]);

            if (operation.equals("add")) {
                result |= (1 << n);
            }
            if (operation.equals("remove")) {
                result &= ~(1 << n);
            }
            if (operation.equals("check")) {
                if ((result & (1 << n)) != 0) {
                    sb.append("1").append("\n");
                } else {
                    sb.append("0").append("\n");
                }
            }
            if (operation.equals("toggle")) {
                if ((result & (1 << n)) == 0) {
                    result |= (1 << n);
                } else {
                    result &= ~(1 << n);
                }
            }
        }
        System.out.println(sb);
    }
}
