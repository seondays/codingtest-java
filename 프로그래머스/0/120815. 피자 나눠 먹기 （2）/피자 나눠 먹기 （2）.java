class Solution {
    public int solution(int n) {
        int min = 6;
        while(min % n != 0) {
            min += 6;
        }
        return min / 6;
    }
}