import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        Stack<Character> stack = new Stack<>();
        int result = 0;
        char[] ca = line.toCharArray();

        for (int i = 0; i < ca.length; i++) {
            if (ca[i] == '(') {
                stack.push(ca[i]);
            } else {
                if (ca[i - 1] == '(') {
                    stack.pop();
                    result += stack.size();
                } else {
                    stack.pop();
                    result += 1;
                }
            }
        }
        System.out.println(result);
    }
}