import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] answers) {
        List<Integer> holder = new ArrayList<>();
        
        int[] one = {1,2,3,4,5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[] result_array = new int[3];
        
        int one_score = getScore(answers, one);
        int two_score = getScore(answers, two);
        int three_score = getScore(answers, three);
        
        result_array[0] = one_score;
        result_array[1] = two_score;
        result_array[2] = three_score;
        
        int max_score = Math.max(one_score, two_score);
        
        max_score = Math.max(max_score, three_score);
        
        System.out.println(max_score);
        
        for (int i = 0; i < 3; i++) {
            if(result_array[i] == max_score) {
                holder.add(i+1);
            }
        }
        
        return holder.stream().mapToInt(i -> i).toArray();
    }
    
    public int getScore(int[] answers, int[] userAnswers) {
        int result = 0;
        
        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == userAnswers[i % userAnswers.length]) {
                result++;
            }
        }
        return result;
    }
}