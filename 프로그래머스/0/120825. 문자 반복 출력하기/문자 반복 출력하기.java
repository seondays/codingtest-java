class Solution {
    public String solution(String my_string, int n) {
        StringBuffer sb = new StringBuffer();
        String[] array = my_string.split("");
        
        for(int i = 0; i < array.length; i++) {
            String word = array[i].repeat(n);
            sb.append(word);
        }
        
        return sb.toString();
    }
}