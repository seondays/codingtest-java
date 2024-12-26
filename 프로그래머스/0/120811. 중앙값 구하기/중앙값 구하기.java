import java.util.*;

class Solution {
    public int solution(int[] array) {
        int[] sortedArray = Arrays.stream(array).sorted().toArray();
        return sortedArray[array.length / 2];
    }
}