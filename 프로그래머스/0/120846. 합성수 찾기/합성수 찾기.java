class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for(int i = 4; i <= n; i++) {
            if(isComposit(i)) {
                answer++;
            }
        }
        return answer;
    }
    
    private boolean isComposit(int n) {
        for(int i = 2; i <= n / 2; i++) {
            if(n % i == 0) {
                return true;
            }
        }
        return false;
    }
}