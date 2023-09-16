import java.util.Scanner;

public class BOJ1152 {
    public static void main(String[] args) {

        int count = 0;
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == ' ' && Character.isAlphabetic(s.charAt(i - 1))) {
                count++;
            }
        }
        if(s.charAt(s.length() - 1) == ' ') {
            count--;
        }
        System.out.println(count + 1);
    }
}
