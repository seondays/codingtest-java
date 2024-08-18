import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String target = br.readLine();

    int count0 = 0;
    int count1 = 0;

    if (target.charAt(0) == '1') {
      count1++;
    } else {
      count0++;
    }

    for (int i = 1 ; i < target.length(); i++) {
      if (target.charAt(i) != target.charAt(i - 1)) {
        if (target.charAt(i) == '1') {
          count1++;
        } else {
          count0++;
        }
      }
    }
    System.out.println(Math.min(count0, count1));
  }
}
