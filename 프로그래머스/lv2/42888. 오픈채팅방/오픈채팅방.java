import java.util.*;
class Solution {
      public StringBuilder[] solution(String[] record) {
        HashMap<String,String> user = new HashMap<>();
        List<String> list = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < record.length ;i++){
            String[] log =  record[i].split(" ");
            if(Objects.equals(log[0],"Enter")){
                user.put(log[1],log[2]);
                list.add(log[0]);
                list.add(log[1]);
            }
            else if(Objects.equals(log[0],"Leave")){
                list.add(log[0]);
                list.add(log[1]);
            }
            else{
                user.put(log[1],log[2]);
            }
        }
        Deque<String> deque = new ArrayDeque<>(list);
        StringBuilder[] answer = new StringBuilder[deque.size()/2];
        count = 0;
        while (!(deque.size() == 0)){
            String check = deque.poll();
            if(Objects.equals(check,"Enter")){
                StringBuilder ans = new StringBuilder(user.get(deque.poll()));
                 ans = new StringBuilder(ans + "님이 들어왔습니다.");
                answer[count] = ans;
                count++;
            }
            else if(Objects.equals(check,"Leave")){
                StringBuilder ans = new StringBuilder(user.get(deque.poll()));
                ans = new StringBuilder(ans + "님이 나갔습니다.");
                answer[count] = ans;
                count++;
            }
        }
        return answer;
    }
}