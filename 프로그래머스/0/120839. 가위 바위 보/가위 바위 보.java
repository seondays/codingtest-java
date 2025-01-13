import java.util.*;

class Solution {
    public String solution(String rsp) {
        Map<String, String> rspMap = new HashMap<>() {{
            put("2", "0");
            put("0", "5");
            put("5", "2");
        }};
        
        StringBuilder sb = new StringBuilder();
        String[] splited = rsp.split("");
        
        for(String part : splited) {
            sb.append(rspMap.get(part));
        }
        
        return sb.toString();
    }
}