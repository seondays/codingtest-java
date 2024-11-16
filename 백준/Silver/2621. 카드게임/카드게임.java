import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] color = new String[5];
        int[] number = new int[5];

        for (int i = 0; i < 5; i++) {
            String[] line = br.readLine().split(" ");
            color[i] = line[0];
            number[i] = Integer.parseInt(line[1]);
        }

        List<Integer> scores = new ArrayList<>();

        // 카드 5장이 모두 같은 색이면서 숫자가 연속적일 때
        if (isAllSameColor(color) && isNumberInRow(number)) {
            int max = Arrays.stream(number).max().orElse(0);
            scores.add(max + 900);
        }
        // 카드 5장 중 4장의 숫자가 같을 때
        int target;
        if ((target = getSameNumber(number, 4)) != -1) {
            scores.add(target + 800);
        }
        // 카드 3장의 숫자가 같고, 나머지 2장의 숫자도 같을 때
        if ((target = same2same3(number)) != -1) {
            scores.add(target);
        }
        // 카드 5장의 색이 모두 같을 때
        if (isAllSameColor(color)) {
            int max = Arrays.stream(number).max().orElse(0);
            scores.add(max + 600);
        }
        // 카드 5장의 숫자가 연속적일 때
        if (isNumberInRow(number)) {
            int max = Arrays.stream(number).max().orElse(0);
            scores.add(max + 500);
        }
        // 카드 5장 중 3장의 숫자가 같을 때
        if ((target = getSameNumber(number, 3)) != -1) {
            scores.add(target + 400);
        }
        // 카드 5장 중 2장의 숫자가 같고 2장의 숫자가 같을 때
        if ((target = same2same2(number)) != -1) {
            scores.add(target);
        }
        // 카드 5장 중 2장의 숫자가 같을 때
        if ((target = getSameNumber(number, 2)) != -1) {
            scores.add(target + 200);
        }
        // 어떠한 경우에도 해당되지 않을 때
        if (scores.size() == 0) {
            int max = Arrays.stream(number).max().orElse(0);
            scores.add(max + 100);
        }

        System.out.println(scores.stream().max(Integer::compareTo).orElse(0));
    }

    // 카드 5 장이 같은 색인가?
    static boolean isAllSameColor(String[] color) {
        Set<String> set = Arrays.stream(color).collect(Collectors.toSet());
        return set.size() == 1;
    }

    // 숫자가 연속적인가?
    static boolean isNumberInRow(int[] number) {
        Arrays.sort(number);
        for (int i = 1; i < number.length; i++) {
            if (number[i] - number[i - 1] != 1) {
                return false;
            }
        }
        return true;
    }

    static int getSameNumber(int[] number, int target) {
        int[] frequency = new int[10];

        for (int j : number) {
            frequency[j]++;
        }

        for (int i = 1; i < frequency.length; i++) {
            if (frequency[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // 3장의 숫자가 같고 나머지 2장도 같을 때
    static int same2same3(int[] number) {
        int[] frequency = new int[10];

        for (int i = 0; i < number.length; i++) {
            frequency[number[i]]++;
        }

        int same2 = -1;
        int same3 = -1;
        for (int i = 1; i < frequency.length; i++) {
            if (frequency[i] == 3) {
                same3 = i;
            } else if (frequency[i] == 2) {
                same2 = i;
            }
        }

        if (same3 > 0 && same2 > 0) {
            return same3 * 10 + same2 + 700;
        }
        return -1;
    }

    static int same2same2(int[] number) {
        int[] frequency = new int[10];

        for (int i = 0; i < number.length; i++) {
            frequency[number[i]]++;
        }

        int same2 = -1;
        int same22 = -1;
        for (int i = 1; i < frequency.length; i++) {
            if (frequency[i] == 2 && same2 == -1) {
                same2 = i;
            } else if (frequency[i] == 2) {
                same22 = i;
            }
        }

        if (same22 > 0 && same2 > 0) {
            if (same22 > same2) {
                return same22 * 10 + same2 + 300;
            } else {
                return same2 * 10 + same22 + 300;
            }
        }
        return -1;
    }
}
