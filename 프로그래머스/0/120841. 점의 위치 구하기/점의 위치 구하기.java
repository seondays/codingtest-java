class Solution {
    public int solution(int[] dot) {
        int sum = dot[0] + dot[1];
        int mul = dot[0] * dot[1];
        
        if (mul > 0) {
           if(sum > 0) {
               return 1;
           }
            return 3;
        }
        
        if (dot[0] < dot[1]) {
            return 2;
        }
        return 4;
    }
}