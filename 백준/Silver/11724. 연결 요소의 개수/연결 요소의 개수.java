import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        
        int vertexCount = Integer.parseInt(st.nextToken());
        int lineCount = Integer.parseInt(st.nextToken());
        
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        Set<Integer> visit = new HashSet<>();
        int result = 0;
        
        for (int i = 1; i <= vertexCount; i++) {
            graph.put(i,new HashSet<>());
        }
        
        for(int i = 0; i < lineCount; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph.computeIfAbsent(start, k -> new HashSet<>()).add(end);
            graph.computeIfAbsent(end, k -> new HashSet<>()).add(start);
        }
        
        for (int i = 1; i <= vertexCount; i++) {
            if (!visit.contains(i)) {
                dfs(graph, i, visit);
                result++;
            }
        }
        System.out.println(result);
    }
    
    public static void dfs(Map<Integer, Set<Integer>> graph, int nowVertex, Set<Integer> visit) {
        if (!visit.contains(nowVertex)) {
            visit.add(nowVertex);
            for(int nextVertex : graph.get(nowVertex)) {
                if(!visit.contains(nextVertex)) {
                    dfs(graph, nextVertex, visit);
                }
            }
        }
    }
}