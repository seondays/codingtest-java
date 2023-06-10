import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BOJ2562 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> lst = new ArrayList<>();
        int n = 9;

        for(int i = 0; i < n; i++ ){
            int e = sc.nextInt();

            lst.add(e);
        }

        System.out.println(Collections.max(lst));
        System.out.println(lst.indexOf(Collections.max(lst))+1);
    }
}
