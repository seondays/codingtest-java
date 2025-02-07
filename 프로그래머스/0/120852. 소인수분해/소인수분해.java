import java.util.*;

class Solution {
    public int[] solution(int n) {
        Set<Integer> answer = new HashSet<>();
        
        while(n % 2 == 0) {
            answer.add(2);
            n /= 2;
        }
        
        for(int i = 3; i <= Math.sqrt(n); i += 2) {
            while(n % i == 0) {
                answer.add(i);
                n /= i;
            }
        }
        
        if (n > 1) {
            answer.add(n);
        }

        
        return answer.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}