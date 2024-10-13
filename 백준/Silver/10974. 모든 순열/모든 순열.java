import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] numbers;
    static boolean[] visit;
    static int[] result;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        numbers = new int[n];
        result = new int[n];
        visit = new boolean[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = i + 1;
        }
        bt(0);
    }

    public static void bt(int index) {
        if (index == n) {
            for(int i = 0; i < n; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }

        // index 자리에 들어갈 수 있는 수를 전부 탐색해야 한다.
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {  // 만일 해당 수가 사용되지 않았다면 선택한다.
                visit[i] = true; // 선택되었다고 표시
                result[index] = numbers[i];  // 현재 인덱스 자리에 해당 수를 저장한다.
                bt(index + 1);  // 다음 인덱스 자리를 확인한다.
                visit[i] = false; // 돌아와서는 방문을 해제한다.
            }
        }
    }
}
