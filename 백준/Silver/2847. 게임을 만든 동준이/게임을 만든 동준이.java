import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int count = Integer.parseInt(br.readLine());
    int[] target = new int[count];

    for (int i = 0; i < count; i++) {
      target[i] = Integer.parseInt(br.readLine());
    }
    System.out.println(solution(target));
  }

  public static int solution(int[] target) {
    int result = 0;

    for (int i = target.length - 1; i > 0; i--) {
      int high = target[i];
      int row = target[i - 1];
      if (row >= high) {
        int minusValue = row - high + 1;
        result += minusValue;
        target[i - 1] = row - minusValue;
      }
    }
    return result;
  }
}
