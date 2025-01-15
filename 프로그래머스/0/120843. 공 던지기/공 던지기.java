class Solution {
    public int solution(int[] numbers, int k) {
        int index = (k - 1) * 2 % numbers.length;
        return numbers[index];
    }
}