import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String line;
        while (true) {
            line = scanner.nextLine();
            if (line.equals(".")) {
                break;
            }
            solution(line);
        }
    }

    public static void solution(String line) {
        Map<Character, Character> mapping = new HashMap<>();
        Stack<Character> stack = new Stack<>();
        List<Character> charList;

        mapping.put(')', '(');
        mapping.put(']', '[');

        charList = new ArrayList<>();
        for (char ch : line.toCharArray()) {
            charList.add(ch);
        }
        if (charList.size() <= 1) {
            System.out.println("no");
            return;
        }
        for (char token : charList) {
            if (token == '(' || token == '[') {
                stack.push(token);
            } else if (token == ')' || token == ']') {
                if (stack.size() == 0) {
                    System.out.println("no");
                    return;
                }
                char top = stack.pop();
                if (top != (mapping.get(token))) {
                    System.out.println("no");
                    return;
                }

            }
        }
        if (stack.size() == 0) {
            System.out.println("yes");

        } else {
            System.out.println("no");
        }
    }
}
