import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String password;

        while (!(password = br.readLine()).equals("end")) {
            if (hasVowels(password) && !is2char(password) && !is3char(password)) {
                System.out.println("<" + password + ">" + " is acceptable.");
                continue;
            }
            System.out.println("<" + password + ">" + " is not acceptable.");
        }
    }

    public static boolean hasVowels(String line) {
        for (char c : line.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                return true;
            }
        }
        return false;
    }

    public static boolean is2char(String line) {
        char[] charArray = line.toCharArray();

        for (int i = 1; i < charArray.length; i++) {
            if (charArray[i] == charArray[i - 1]) {
                return charArray[i] != 'e' && charArray[i] != 'o';
            }
        }
        return false;
    }

    public static boolean is3char(String line) {
        char[] charArray = line.toCharArray();

        for (int i = 2; i < charArray.length; i++) {
            char first = charArray[i];
            char second = charArray[i - 1];
            char thrid = charArray[i - 2];

            if (isVowels(first) && isVowels(second) && isVowels(thrid)) {
                return true;
            }

            if (!isVowels(first) && !isVowels(second) && !isVowels(thrid)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isVowels(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
