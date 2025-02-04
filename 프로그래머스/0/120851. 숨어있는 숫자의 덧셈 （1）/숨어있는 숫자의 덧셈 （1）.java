class Solution {
    public int solution(String my_string) {
        char[] nums = my_string.replaceAll("[A-Z|a-z]", "").toCharArray();
        int answer = 0;
        
        for(int i = 0; i < nums.length; i++) {
            answer += nums[i] - '0';
        }
        
        return answer;
    }
}