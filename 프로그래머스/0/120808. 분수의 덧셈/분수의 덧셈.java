class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer;
        
        int lcm = lcm(denom1, denom2);
        
        int numer = (numer1 * (lcm / denom1)) + (numer2 * (lcm / denom2));
        int demon = lcm;
        
        int gcd = gcd(numer, demon);
        
        answer = new int[]{numer/gcd, demon/gcd};
        
        return answer;
    }
    
    public int gcd(int a, int b){
        int temp;
        while(b != 0) {
            temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    public int lcm(int a, int b){
        return (a * b) / gcd(a, b);
    }
}