package Grind75;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParentheses {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for(char c : s.toCharArray()) {
            if (c == '[' || c == '{' || c == '(') {
                stack.push(c);
            }
            else {
                if (stack.isEmpty()) {
                    return false;
                }
                char tmp = stack.pop();
                if (!((c == ']' && tmp == '[') || (c == '}' && tmp == '{') || (c == ')' && tmp == '('))) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}

