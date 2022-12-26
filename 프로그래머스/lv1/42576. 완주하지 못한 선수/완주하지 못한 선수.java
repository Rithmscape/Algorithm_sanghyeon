import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        PriorityQueue<String> start = new PriorityQueue<>();
        PriorityQueue<String> end = new PriorityQueue<>();
        String answer ="";
        for (int i = 0; i < participant.length ;i++){
            start.add(participant[i]);
        }
        for (int j = 0; j < completion.length ;j++){
            end.add(completion[j]);
        }

        while (start.size()> 0){
            if(Objects.equals(start.peek(), end.peek())){
                start.poll();end.poll();
            }
            else {answer = start.poll();}
        }
        return answer;
    }
}