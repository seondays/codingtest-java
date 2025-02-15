import java.util.*;

class Solution {
    public String solution(String cipher, int code) {
        StringBuilder sb = new StringBuilder();
        char[] charArray = cipher.toCharArray();
        for(int i = code; i <= charArray.length; i += code) {
            sb.append(charArray[i - 1]);
        }
        return sb.toString();
    }
}