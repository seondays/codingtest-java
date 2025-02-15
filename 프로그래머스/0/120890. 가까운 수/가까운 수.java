class Solution {
    public int solution(int[] array, int n) {
        int answer = 0;
        int cal = Integer.MAX_VALUE;
        for(int target : array) {
            int sub = Math.abs(target - n);
            if(sub == cal) {
                if(answer > target) {
                    answer = target;
                    cal = sub;
                }
            }
            if(sub < cal) {
                answer = target;
                cal = sub;
            }
        }
        return answer;
    }
}