import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int solution(int[][] board, int[] moves) {
    Deque<Integer> queue = new ArrayDeque<>();
    int answer = 0;

    for(int i = 0; i < moves.length; i++) {
      for(int j = 0; j < board.length; j++) {
        int target = board[j][moves[i]-1];
        if(target > 0) {
            board[j][moves[i]-1] = 0;
          if(queue.peekLast() != null && queue.peek() == target) {
            answer += 2;
            queue.pop();
            break;
          }
          queue.push(target);
          break;
        }
      }
    }
    return answer;   
    }
}