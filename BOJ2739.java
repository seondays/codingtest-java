import java.util.Scanner;

public class BOJ2739 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String timesMark = " * ";
        String equalsMark = " = ";

        for(int i = 1; i < 10; i++){
            int m = n*i;
            System.out.println(n+timesMark+i+equalsMark+m);
        }
    }
}