class Solution {
    public int solution(String t, String p) {
                Long compare = Long.parseLong(p);
        StringBuilder stringBuilder =new StringBuilder(t);
        StringBuilder buffer ;
        int answer = 0;
        int len = t.length()-p.length();

        for (int i= 0; i < len+1;i++){
            buffer = new StringBuilder(stringBuilder.substring(i, i + p.length()));
            if(compare>=Long.parseLong(String.valueOf(buffer))){
                answer++;
            }
        }
        return answer;
    }
}