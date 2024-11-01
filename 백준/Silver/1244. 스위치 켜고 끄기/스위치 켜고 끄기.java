import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf)
                .toArray();

        int[] switches = new int[input.length + 1];
        switches[0] = 0;

        System.arraycopy(input, 0, switches, 1, input.length);

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int gender = Integer.parseInt(st.nextToken());
            int switchN = Integer.parseInt(st.nextToken());
            int start = switchN;

            if (gender == 2) {
                switches = twoPointer(switches, switchN);
                continue;
            }

            if (gender == 1) {
                while (switchN < switches.length) {
                    switches[switchN] = switches[switchN] ^ 1;
                    switchN += start;
                }
            }
        }

        for(int i = 1; i < switches.length; i++) {
            System.out.print(switches[i] + " ");
            if(i % 20 == 0) {
                System.out.println();
            }
        }
    }

    public static int[] twoPointer(int[] switches, int index) {
        int one = index - 1;
        int two = index + 1;

        while (one > 0 && two < switches.length && switches[one] == switches[two]) {
            switches[one] = switches[one] ^ 1;
            switches[two] = switches[two] ^ 1;

            one--;
            two++;

            if (one < 1 || two >= switches.length) {
                break;
            }
        }

        switches[index] = switches[index] ^ 1;

        return switches;
    }
}
