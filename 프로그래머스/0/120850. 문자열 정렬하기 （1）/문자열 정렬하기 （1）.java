import java.util.*;

class Solution {
    public int[] solution(String my_string) {
        char[] my_char = my_string.toCharArray();
        List<Integer> answer = new ArrayList<>();
        
        for(int i = 0; i < my_char.length; i++) {
            if(my_char[i] >= 48 && my_char[i] <= 57) {
                answer.add(my_char[i] - '0');
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).sorted().toArray();
    }
}