class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int add = 0;
        while (n>=a & n!=0 ) {
             add = (n/a)*b ;
             answer = answer+add;
             n = add+(n%a);
             add = 0;
        }
        return answer;
    }
}