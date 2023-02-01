class Solution {
    public int solution(String s) {
        char buffer = s.charAt(0);
        int answer = 0;
        int count = 1;
        int check = 0;

        for (int i = 1; i < s.length(); i++) {
            if (buffer == ' ') {
                buffer = s.charAt(i);
                continue; //만나면 해당 반복부분 탈출 후 다음반복실행
            }
            if (buffer == s.charAt(i)) {
                count++;
            }else{
                check++;
            }
            if (count == check) {
                answer++;
                buffer = ' ';
                count = 1;
                check = 0;
            }
        }
        if (buffer != ' ') {
            answer++;
        }

        return answer;
    }
}