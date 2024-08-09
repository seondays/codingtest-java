import java.util.stream.*;
import java.io.*;

public class Main {
    public static void main(String[] agrs) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        
        Stream.generate(() -> "SciComLove")
            .limit(count)
            .forEach(System.out::println);
    }
}