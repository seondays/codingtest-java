import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

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
    int[] negativeTarget = Arrays.stream(target).filter(value -> value < 1).sorted().toArray();
    int[] positiveTarget = Arrays.stream(target).filter(value -> value > 0).sorted().toArray();

    for (int i = positiveTarget.length - 1; i > -1; i--) {

      if ((positiveTarget.length % 2 != 0 && i == 0)) {
        result += positiveTarget[i];
        break;
      }
      if (positiveTarget[i] > 1 && positiveTarget[i - 1] > 1) {
        result += positiveTarget[i] * positiveTarget[i - 1];
      } else {
        result += positiveTarget[i] + positiveTarget[i - 1];
      }
      i--;
    }

    for (int i = 0; i < negativeTarget.length; i++) {
      if (negativeTarget.length % 2 != 0 && i == negativeTarget.length - 1) {
        result += negativeTarget[negativeTarget.length - 1];
        break;
      }
      result += negativeTarget[i] * negativeTarget[i + 1];
      i++;
    }

    return result;
  }

}
