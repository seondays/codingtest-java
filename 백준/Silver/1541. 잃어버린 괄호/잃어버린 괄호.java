import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line = br.readLine();
    String[] lineArray = line.split("-");
    int[] lineInt = new int[lineArray.length];

    for (int i = 0; i < lineArray.length; i++) {
      String[] addArray = lineArray[i].split("\\+");
      int buffer = Arrays.stream(addArray).mapToInt(Integer::parseInt).sum();
      lineInt[i] = buffer;
    }

    int result = Arrays.stream(lineInt).reduce((a, b) -> a - b).getAsInt();
    System.out.println(result);
  }
}
