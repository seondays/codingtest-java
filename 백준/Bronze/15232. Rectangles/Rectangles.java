import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sb = new BufferedReader(new InputStreamReader(System.in));
        int row = Integer.parseInt(sb.readLine());
        int column = Integer.parseInt(sb.readLine());
        char mark = '*';

        for(int i = 0; i < row; i++) {
          for (int j = 0; j < column; j++) {
            System.out.print(mark);
          }
          System.out.println();
        }
    }
}