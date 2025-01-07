import java.util.*;

class Solution {
    public int[] solution(int[] emergency) {
        int[] sorted = Arrays.stream(emergency).sorted().toArray();
        int[] answer = new int[sorted.length];
        Map<Integer, Integer> rank = new HashMap<>();
        
        for(int i = 0; i < sorted.length; i++) {
            rank.put(sorted[i], sorted.length - i);
        }
        
        for(int i = 0; i < sorted.length; i++) {
            answer[i] = rank.get(emergency[i]);
        }
        
        return answer;
    }
}