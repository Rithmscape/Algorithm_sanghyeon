class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int add = 0;
        while (n>=a & n!=0 ) {
            if(n >= a) {
                while (n>=a){
                   n = n-a;
                   add = add+b;
                   answer = answer+b;
                }
                n = n+add;
                add = 0;
            }
        }
        return answer;
    }
}