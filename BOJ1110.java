import java.util.Scanner;

public class BOJ1110 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int first;
        int second;
        String nToString;
        int cycle = 0;
        int save = n;

        while (true){
            first = n/10;
            second = n%10;

            first = first+second;
            nToString = String.valueOf(second) + String.valueOf(first%10);
            n = Integer.parseInt(nToString);
            cycle++;
            if(save == n){
                break;
            }
        }
        System.out.println(cycle);
    }
}
