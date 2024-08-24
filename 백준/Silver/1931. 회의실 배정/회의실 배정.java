import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    // 하나의 자원을 최대한 많이 사용하기. 회의는 일찍 끝나는 순서대로 배정한다.
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int taskCount = Integer.parseInt(br.readLine());

    int[][] taskList = new int[taskCount][2];
    for (int i = 0; i < taskCount; i++) {
      st = new StringTokenizer(br.readLine());

      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());

      taskList[i][0] = start;
      taskList[i][1] = end;
    }

    // 정렬 필요
    Arrays.sort(taskList, ((o1, o2) -> {
      if (o1[1] == o2[1]) {
        return o1[0] - o2[0];
      }
      return o1[1] - o2[1];
    }));

    int result = 0;
    int nowTime = -1;
 
    for (int i = 0; i < taskCount; i++) {
      if (nowTime <= taskList[i][0]) {
        nowTime = taskList[i][1];
        result++;
      }
    }
    System.out.println(result);
  }
}
