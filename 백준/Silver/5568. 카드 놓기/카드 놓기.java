import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    static int n;
    static int k;
    static int[] numbers;
    static boolean[] visit;
    static Set<String> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        visit = new boolean[n];
        result = new HashSet<>();
        numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        bt(0,"");
        System.out.println(result.size());
    }

    private static void bt(int index, String buffer) {
        // k개만큼 만들어져 있다면 종료
        if (index == k) {
            // 만들어진 숫자를 저장. set으로 인해 중복은 자동적으로 걸러진다
            result.add(buffer);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                bt(index + 1, buffer + numbers[i]);
                visit[i] = false;
            }
        }
    }
}
