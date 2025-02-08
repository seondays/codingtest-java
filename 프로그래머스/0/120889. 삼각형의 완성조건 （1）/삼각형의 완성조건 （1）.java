import java.util.*;

class Solution {
    public int solution(int[] sides) {
        int[] sorted = Arrays.stream(sides).sorted().toArray();
        
        int answer = 0;
        
        if(sorted[2] < sorted[0] + sorted[1]) {
            return 1;
        }
        return 2;
    }
}