import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        Map<String, Integer> countMap = new HashMap<>();

        for (char c : line.toCharArray()) {
            String string = String.valueOf(c).toUpperCase();
            countMap.put(string, countMap.getOrDefault(string, 0) + 1);
        }

        int max = countMap.values().stream().mapToInt(Integer::valueOf).max().orElse(0);
        ArrayList<String> result = new ArrayList<>();

        countMap.forEach((k, v) -> {
            if (v == max) {
                result.add(k);
            }
        });

        if (result.size() > 1) {
            System.out.println("?");
        } else {
            System.out.println(result.get(0));
        }
    }
}
