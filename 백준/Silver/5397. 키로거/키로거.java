import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) {
            Stack<String> leftStack = new Stack<>();
            Stack<String> rightStack = new Stack<>();
            String line = br.readLine();
            for (String s : line.split("")) {
                if (s.equals(">") && !rightStack.empty()) {
                    leftStack.push(rightStack.pop());
                } else if (s.equals("<") && !leftStack.empty()) {
                    rightStack.push(leftStack.pop());
                } else if (s.equals("-") && !leftStack.empty()) {
                    leftStack.pop();
                } else if (!s.equals(">") && !s.equals("<") && !s.equals("-")) {
                    leftStack.push(s);
                }
            }
            while(!leftStack.empty()) {
                rightStack.push(leftStack.pop());
            }
            StringBuffer sb = new StringBuffer();
            while (!rightStack.empty()) {
                sb.append(rightStack.pop());
            }
            System.out.println(sb);
        }
    }
}
