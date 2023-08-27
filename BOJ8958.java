import java.util.Scanner;

public class BOJ8958 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = sc.nextInt();
        sc.nextLine();

        for(int i = 0; i < count ; i++){
            String p = sc.nextLine();
            int score = 0;
            int total = 0;

            for(char word : p.toCharArray()){
                if(word == 'O'){
                    score++;
                    total += score;
                }
                if(word == 'X'){
                    score = 0;
                }
            }
            System.out.println(total);
        }
    }
}
