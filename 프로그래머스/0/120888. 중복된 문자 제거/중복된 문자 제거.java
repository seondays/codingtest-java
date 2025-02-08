import java.util.*;
import java.util.stream.*;


class Solution {
    public String solution(String my_string) {
        Set<String> string_set = new LinkedHashSet<>();
        
        for(String s : my_string.split("")) {
            string_set.add(s);
        }
        
        return string_set.stream().map(String::valueOf)
                               .collect(Collectors.joining());
    }
}