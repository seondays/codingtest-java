import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BOJ10871 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int x = sc.nextInt();
        ArrayList<Integer> aArrLst = new ArrayList<>();

        for(int i = 0; i < n; i++){
            int a = sc.nextInt();
            if(a < x){
                aArrLst.add(a);
            }
        }

        String output = aArrLst.stream()
                .map(Object::toString)
                .collect(Collectors.joining(" "));

        System.out.println(output);
    }
}
