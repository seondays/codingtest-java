import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int count = Integer.parseInt(br.readLine());

    for (int i = 0; i < count; i++) {
      int days = Integer.parseInt(br.readLine());
      int[] target = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      System.out.println(solution(target));
    }
  }

  public static long solution(int[] target) {
    long result = 0;
    int maxPrice = target[target.length-1];

    for (int i = target.length - 1; i > -1; i--) {
      if (target[i] > maxPrice) {
        maxPrice = target[i];
        continue;
      }
      result += maxPrice - target[i];
    }
    return result;
  }
}
