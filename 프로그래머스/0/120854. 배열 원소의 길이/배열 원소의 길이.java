class Solution {
    public int[] solution(String[] strlist) {
        int[] answer = new int[strlist.length];
        
        for(int i = 0; i < strlist.length; i++) {
            String[] splited = strlist[i].split("");
            answer[i] = splited.length;
        }
        return answer;
    }
}