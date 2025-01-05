import java.util.stream.*;

class Solution {
    public String solution(String my_string, String letter) {
        char cletter = letter.charAt(0);
        return my_string.chars().filter(c -> c != cletter).mapToObj(c -> String.valueOf((char) c)).collect(Collectors.joining());
    }
}