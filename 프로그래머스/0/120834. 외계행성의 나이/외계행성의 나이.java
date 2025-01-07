class Solution {
    public String solution(int age) {
        StringBuffer sb = new StringBuffer();
        
        while(age > 0) {
            char target = (char) (age % 10 + 'a');
            sb.append(target);
            age = age / 10;
        }
        
        return sb.reverse().toString();
    }
}