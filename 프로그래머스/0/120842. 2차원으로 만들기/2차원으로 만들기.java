class Solution {
    public int[][] solution(int[] num_list, int n) {
        int size = num_list.length / n;
        int[][] result = new int[size][n];
        
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < n; j++) {
                result[i][j] = num_list[i * n + j];
            }
        }
        return result;
    }
}