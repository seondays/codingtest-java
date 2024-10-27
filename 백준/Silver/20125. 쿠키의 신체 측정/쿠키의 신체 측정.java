import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    static String[][] table;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        table = new String[n][n];

        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split("");
            table[i] = line;
        }

        StringBuffer sb = new StringBuffer();

        int[] heart = findHeart();

        sb.append(Arrays.stream(heart).map(n -> n + 1).mapToObj(String::valueOf).collect(Collectors.joining(" ")))
                .append("\n");
        sb.append(Arrays.stream(arms(heart)).mapToObj(String::valueOf)
                .collect(Collectors.joining(" "))).append(" ");

        int[] back = back(heart);
        sb.append(back[0]).append(" ");
        sb.append(Arrays.stream(legs(new int[]{back[1], back[2]})).mapToObj(String::valueOf)
                .collect(Collectors.joining(" ")));

        System.out.println(sb);
    }

    public static int[] findHeart() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (table[i][j].equals("*")) {
                    return new int[]{i + 1, j};
                }
            }
        }
        return null;
    }

    public static int[] arms(int[] heart) {
        int[] now = heart;
        int[] right = new int[]{0, 1};
        int[] left = new int[]{0, -1};
        int[] result = new int[2];

        while (true) {
            int nextX = right[0] + now[0];
            int nextY = right[1] + now[1];
            if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= n || table[nextX][nextY].equals(
                    "_")) {
                break;
            }
            result[1]++;
            now = new int[]{nextX, nextY};
        }

        now = heart;

        while (true) {
            int nextX = left[0] + now[0];
            int nextY = left[1] + now[1];
            if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= n || table[nextX][nextY].equals(
                    "_")) {
                break;
            }
            result[0]++;
            now = new int[]{nextX, nextY};
        }
        return result;
    }

    public static int[] back(int[] heart) {
        int[] now = heart;
        int[] result = new int[3];

        while (true) {
            int nextX = now[0] + 1;
            int nextY = now[1];

            if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= n || table[nextX][nextY].equals(
                    "_")) {
                break;
            }
            result[0]++;
            now = new int[]{nextX, nextY};
            result[1] = nextX;
            result[2] = nextY;
        }
        return result;
    }

    public static int[] legs(int[] start) {
        int[] now = new int[]{start[0] + 1, start[1] - 1};
        int[] result = new int[]{1, 1};

        while (true) {
            int nextX = now[0] + 1;
            int nextY = now[1];
            if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= n || table[nextX][nextY].equals(
                    "_")) {
                break;
            }
            result[0]++;
            now = new int[]{nextX, nextY};
        }

        now = new int[]{start[0] + 1, start[1] + 1};

        while (true) {
            int nextX = now[0] + 1;
            int nextY = now[1];
            if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= n || table[nextX][nextY].equals(
                    "_")) {
                break;
            }
            result[1]++;
            now = new int[]{nextX, nextY};
        }
        return result;
    }
}
