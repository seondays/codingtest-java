import java.util.Scanner;

public class BOJ9012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for(int i = 0; i < n; i++){
            String[] ps = sc.next().split("");

            int left = 0;
            int right = 0;
            boolean check = true;

            for(int k = 0; k < ps.length; k++){
                if(ps[k].equals("(")){
                    left++;
                }
                if(ps[k].equals(")")){
                    right++;
                }

                if(left < right){
                    System.out.println("NO");
                    check = false;
                    break;
                }
            }
            if(left == right){
                System.out.println("YES");
            }
            if((left != right) && check){
                System.out.println("NO");
            }
        }
    }
}
