import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int t = Integer.parseInt(br.readLine());
            int[] test = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf)
                    .toArray();

            //개수를 카운팅하여 Map으로 저장
            Map<Integer, Long> countMap = Arrays.stream(test)
                    .boxed()
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

            // countMap에서 리스트로 필터링
            List<Integer> filteredList = Arrays.stream(test)
                    .boxed()
                    .filter(num -> countMap.get(num) >= 6)
                    .collect(Collectors.toList());

            // 점수 계산
            Map<Integer, Integer> score = new HashMap<>();
            Map<Integer, Integer> runnerCounts = new HashMap<>();

            for (int j = 0; j < filteredList.size(); j++) {
                int team = filteredList.get(j);
                runnerCounts.put(team, runnerCounts.getOrDefault(team, 0) + 1);

                if (runnerCounts.get(team) <= 4) {
                    score.put(team, score.getOrDefault(team, 0) + (j + 1));
                }
            }

            // 공동 1등팀 가려내기
            List<Integer> tie = new ArrayList<>();
            int min = score.values().stream().mapToInt(Integer::valueOf).min().orElse(0);

            score.entrySet().stream().filter(s -> s.getValue() == min)
                    .forEach(s -> tie.add(s.getKey()));

            if (tie.size() < 2) {
                System.out.println(tie.get(0));
                continue;
            }

            // 공동 1등팀 사이에서 5번째 참가 선수가 가장 먼저 들어온 팀 찾기
            Map<Integer, Integer> ranks = new HashMap<>();
            Map<Integer, Integer> runnerCount = new HashMap<>();

            for (int j = 0; j < filteredList.size(); j++) {
                int team = filteredList.get(j);
                if (tie.contains(team)) {
                    runnerCount.put(team, runnerCount.getOrDefault(team, 0) + 1);

                    if (runnerCount.get(team) == 5) {
                        ranks.put(team, j);
                    }
                }
            }

            System.out.println(
                    ranks.entrySet().stream().min(Entry.comparingByValue()).map(Map.Entry::getKey)
                            .orElse(0));
        }
    }
}
