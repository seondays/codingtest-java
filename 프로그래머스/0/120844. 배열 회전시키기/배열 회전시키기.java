class Solution {
    public int[] solution(int[] numbers, String direction) {
        int[] result = new int[numbers.length];
        int index = 0;
        
        if(direction.equals("right")) {
            index = 1;
        } else {
            index = -1;
        }
        
        for(int i = 0; i < result.length; i++) {
            result[(i + index + result.length) % result.length] = numbers[i];
        }
        
        return result;
    }
}