import java.util.*;

class Solution {
    public int solution(int[] array) {
        Map<Integer, Integer> count = new HashMap<>();
        
        for(int i : array) {
            if(count.containsKey(i)) {
                count.put(i, count.get(i) + 1);
            } else {
                count.put(i, 1);
            }
        }
        
        Set<Integer> mins = new HashSet<>();
        int maxFrequency = 0;
        
        for (int value : count.values()) {
            if (value > maxFrequency) {
                maxFrequency = value;
            }
        }
        
        for(Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            
            if(value == maxFrequency) {
                mins.add(key);
            }
        }
        
        if(mins.size() > 1) {
            return -1;
        } else{
            List<Integer> toList = new ArrayList<>(mins);
            return toList.get(0);
        }
    }
}