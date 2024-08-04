import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] agrs) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < count; i++) {
            int target = Integer.parseInt(br.readLine());
            System.out.println(solution(target));
        }
    }
    
    public static int solution(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 4;
        
        int[] save = new int[n + 1];
        save[1] = 1;
        save[2] = 2;
        save[3] = 4;
        
        for(int i = 4; i < save.length; i++) {
            save[i] = save[i - 1] + save[i - 2] + save[i - 3];
        }
        return save[n];
    }
}