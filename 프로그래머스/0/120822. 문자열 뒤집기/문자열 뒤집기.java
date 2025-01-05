import java.util.*;

class Solution {
    public String solution(String my_string) {
        StringBuffer sb = new StringBuffer();
        int size = my_string.length();
        String[] array = my_string.split("");
        
        for(int i = size - 1; i >= 0; i--) {
            sb.append(array[i]);
        }        
        
        return sb.toString();
    }
}