class Solution {
    public int solution(int n) {
        String buffer = Integer.toString(n,3);
        
        StringBuffer stringBuffer = new StringBuffer(buffer);
        String revers= stringBuffer.reverse().toString();
        int answer = Integer.parseInt(revers,3);
        return answer;
    }
}