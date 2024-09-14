import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line = bufferedReader.readLine();
        Stack<Character> stack = new Stack<>();
        char[] charArray = line.toCharArray();

        int result = 0;
        int temp = 1;

        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '(') {
                temp *= 2;
                stack.push(charArray[i]);
            }
            if (charArray[i] == '[') {
                temp *= 3;
                stack.push(charArray[i]);
            }
            if (charArray[i] == ')') {
                // 완성된 괄호인지 확인한다
                if (stack.size() == 0 || stack.peek() == '[') {
                    System.out.println(0);
                    return;
                } else if (charArray[i - 1] == '(') {
                    result += temp;
                }
                temp /= 2;
                stack.pop();
            }
            if (charArray[i] == ']') {
                // 완성된 괄호인지 확인한다.
                if (stack.size() == 0 || stack.peek() == '(') {
                    System.out.println(0);
                    return;
                } else if (charArray[i - 1] == '[') {
                    result += temp;
                }
                temp /= 3;
                stack.pop();
            }
        }
        if (!stack.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(result);
        }
    }
}
