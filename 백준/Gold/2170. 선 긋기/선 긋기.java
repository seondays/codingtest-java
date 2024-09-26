import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        List<List<Integer>> lines = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            List<Integer> line = new ArrayList<>();
            line.add(Integer.parseInt(st.nextToken()));
            line.add(Integer.parseInt(st.nextToken()));
            line.sort((o1, o2) -> o1 - o2);
            lines.add(line);
        }

        lines.sort((o1, o2) -> o1.get(0) - o2.get(0));
        int result = 0;
        int nowStart = lines.get(0).get(0);
        int nowEnd = lines.get(0).get(1);

        for (int i = 1; i < lines.size(); i++) {
            int nextStart = lines.get(i).get(0);
            int nextEnd = lines.get(i).get(1);

            if (nextStart > nowEnd) {
                result += nowEnd - nowStart;
                nowStart = nextStart;
                nowEnd = nextEnd;
            }
            if (nowEnd < nextEnd) {
                nowEnd = nextEnd;
            }

        }

        result += nowEnd - nowStart;
        System.out.println(result);
    }
}
