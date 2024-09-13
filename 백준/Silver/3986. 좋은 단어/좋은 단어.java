import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int result = 0;

        for (int i = 0; i < count; i++) {
            String line = br.readLine();
            result += solution(line);
        }

        System.out.println(result);
    }

    public static int solution(String line) {
        Stack<Character> stack = new Stack<>();

        for (char c : line.toCharArray()) {
            if (stack.size() == 0) {
                stack.push(c);
                continue;
            }
            char top = stack.peek();
            if (top == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        if (stack.size() == 0) {
            return 1;
        } else {
            return 0;
        }
    }
}
