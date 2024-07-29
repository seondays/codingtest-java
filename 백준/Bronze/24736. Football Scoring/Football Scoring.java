import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System. in));
        StringTokenizer st;
        List<Integer> myTeam = new ArrayList<>();
        List<Integer> yourTeam = new ArrayList<>();
        List<Integer> score = List.of(6,3,2,1,2);
        int myScore = 0;
        int yourScore = 0;

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
          myTeam.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
          yourTeam.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < myTeam.size(); i++) {
          myScore += myTeam.get(i) * score.get(i);
          yourScore += yourTeam.get(i) * score.get(i);
        }

        System.out.println(myScore + " " + yourScore);
    }
}