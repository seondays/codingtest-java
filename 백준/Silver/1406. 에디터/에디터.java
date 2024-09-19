
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String line = br.readLine();
        int count = Integer.parseInt(br.readLine());
        LinkedList<Character> list = new LinkedList<>();

        for (char s : line.toCharArray()) {
            list.add(s);
        }

        ListIterator<Character> iterator = list.listIterator();
        while(iterator.hasNext()) {
            iterator.next();
        }

        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());
            String commend = st.nextToken();
            char target;
            if (commend.equals("P")) {
                target = st.nextToken().charAt(0);
                iterator.add(target);
            }
            if (commend.equals("L")) {
                if (iterator.hasPrevious()) {
                    iterator.previous();
                }
            }
            if (commend.equals("D")) {
                if (iterator.hasNext()) {
                    iterator.next();
                }
            }
            if (commend.equals("B") && iterator.hasPrevious()) {
                iterator.previous();
                iterator.remove();
            }

        }
        StringBuilder result = new StringBuilder();
        for (char ch : list) {
            result.append(ch);
        }
        System.out.println(result);
    }
}
