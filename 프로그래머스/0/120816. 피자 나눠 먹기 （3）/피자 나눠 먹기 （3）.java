class Solution {
    public int solution(int slice, int n) {
        int result = slice;
        int answer = 1;
        while(result < n) {
            result += slice;
            answer++;
        }
        return answer;
    }
}