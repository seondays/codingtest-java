class Solution {
    public int solution(int order) {
        int answer = 0;
        
        while(order > 0) {
            int target = order % 10;
            order /= 10;
            
            if(target == 3 || target == 6 || target == 9) {
                answer++;
            }
        }
        return answer;
    }
}