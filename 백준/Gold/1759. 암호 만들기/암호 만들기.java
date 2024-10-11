import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static String[] result;
    private static boolean[] visit;
    private static String[] strings;
    private static int l;
    private static int c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();

        // c개중에 l개 선택

        l = nums[0];
        c = nums[1];

        strings = br.readLine().split(" ");
        Arrays.sort(strings);

        result = new String[l];
        visit = new boolean[c];
        int index = 0;

        backtrack(index);
    }

    public static void backtrack(int index) {
        if (index == l) {
            if (isValid()) {
                for (String s : result) {
                    System.out.print(s);
                }
                System.out.println();
            }
            return;
        }

        for (int i = 0; i < strings.length; i++) {
            if (index > 0 && strings[i].compareTo(result[index - 1]) < 0) {
                continue;
            }

            if (!visit[i]) {
                visit[i] = true;
                result[index] = strings[i];
                backtrack(index + 1);
                visit[i] = false;
            }
        }
    }

    // 자음
    private static boolean isVowel(String word) {
        return word.equals("a") || word.equals("e") || word.equals("i") || word.equals("o")
                || word.equals("u");
    }


    // 암호가 조건을 만족하는지 확인
    public static boolean isValid() {
        int vowelCount = 0;
        int consonantCount = 0;

        for (String s : result) {
            if (isVowel(s)) {
                vowelCount++;
            } else {
                consonantCount++;
            }
        }

        return vowelCount >= 1 && consonantCount >= 2;
    }
}
