class Solution {
    public int[] solution(String s) {
        int count = 0;
        int zero = 0;

        while (s.length()>1){
            int len = s.length();
            s = s.replaceAll("0","");
            len = len-s.length();
            count++;
            zero = zero+len;
            s = Integer.toString(s.length(),2);
        }
        int[] answer = {count,zero};
        return answer;
    }
}