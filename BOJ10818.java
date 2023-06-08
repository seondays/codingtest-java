import java.util.*;

public class BOJ10818 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Integer> lst = new ArrayList<>();

        for(int i = 0; i < n; i++){
            int e = sc.nextInt();
            lst.add(e);
        }

        int max_lst = Collections.max(lst);
        int min_lst = Collections.min(lst);

        System.out.print(min_lst+" ");
        System.out.println(max_lst);

    }
}
