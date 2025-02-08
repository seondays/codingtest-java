class Solution {
    public int solution(String s) {
        String[] arrays = s.split(" ");
        int result = 0;
        int save = 0;
        
        for(int i = 0; i < arrays.length; i++) {
            if (!arrays[i].equals("Z")){
                save = Integer.parseInt(arrays[i]);
                result += save;
            } else {
                result -= save;
            }
        }
        return result;
    }
}