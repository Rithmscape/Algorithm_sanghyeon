class Solution {
    public int solution(int n, int m, int[] section) {
         int start = section[0];
        int answer = 1;
        int taget = 1;
        while (taget< section.length){
           int length = section[taget]-start;
           if(length>=m){
             answer++;
             start = section[taget];
           }
            taget++;
        }
        return answer;
    }
}