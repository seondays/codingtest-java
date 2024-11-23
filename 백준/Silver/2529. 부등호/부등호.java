import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    static int[] result;
    static List<String> resultList;
    static boolean[] visited;
    static String[] sign;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        resultList = new ArrayList<>();
        sign = br.readLine().split(" ");
        visited = new boolean[10];
        result = new int[n + 1];
        bt(0);
        System.out.println(Collections.max(resultList));
        System.out.println(Collections.min(resultList));
    }

    static void bt(int depth) {
        // 만약 result를 끝까지 채웠으면 출력
        if (depth == result.length) {
            StringBuilder sb = new StringBuilder();
            for (int digit : result) {
                sb.append(digit);
            }
            resultList.add(sb.toString());
            return;
        }
        // 반복문 시작
        for (int i = 0; i < 10; i++) {
            if (!visited[i]) {
                // 부등호 조건 체크
                if (depth == 0 || check(result[depth - 1], i, sign[depth - 1])) {
                    // 조건에 맞는다면 result 추가
                    result[depth] = i;
                    visited[i] = true;
                    // 다시 bt 함수 실행
                    bt(depth + 1);
                    // 숫자 방문 해제
                    visited[i] = false;
                }
            }
        }
    }

    static boolean check(int left, int right, String sign) {
        if (sign.equals(">")) {
            return left > right;
        }
        if (sign.equals("<")) {
            return left < right;
        }
        return false;
    }

}
