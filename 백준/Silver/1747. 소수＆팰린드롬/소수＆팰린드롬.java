import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        while (true) {
            if (isPalindrome(n)) {
                if (isPrime(n)) {
                    System.out.println(n);
                    break;
                }
            }
            n++;
        }
    }

    static boolean isPrime(int n) {
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);
        prime[1] = false;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (prime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = false;
                }
            }
        }
        return prime[n];
    }

    static boolean isPalindrome(int n) {
        String text = String.valueOf(n);
        Stack<String> stack = new Stack<>();
        
        for (String s : text.split("")) {
            stack.push(s);
        }
        for (String s : text.split("")) {
            if (!stack.pop().equals(s)) {
                return false;
            }
        }
        return true;
    }
}
