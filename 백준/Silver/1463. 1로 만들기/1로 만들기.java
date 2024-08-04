import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[] save = new int[n + 1];
        
        for (int i = 2; i < save.length; i++) {
            save[i] = save[i - 1] + 1;
            if (i % 2 == 0) {
                save[i] = Math.min(save[i], save[i / 2] + 1);
              
            }    
            if (i % 3 == 0) {
                save[i] = Math.min(save[i], save[i / 3] + 1);
            }
        }
        System.out.println(save[n]);
    }
}