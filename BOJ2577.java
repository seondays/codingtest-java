import java.util.Scanner;

public class BOJ2577 {
    public static void main(String[] args) {
        int[] numbers = new int[10];
        int a,b,c;
        String result;
        Scanner sc = new Scanner(System.in);

        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();
        result = Integer.toString(a*b*c);

        for(int i = 0; i < 10; i++){
            String indexToString = Integer.toString(i);

            int count = result.length() - result.replace(indexToString,"").length();
            numbers[i] = count;

            System.out.println(numbers[i]);
        }
    }
}
