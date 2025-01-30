import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        int[] sorted = Arrays.stream(numbers).sorted().toArray();
        return sorted[numbers.length - 1] * sorted[numbers.length - 2];
    }
}