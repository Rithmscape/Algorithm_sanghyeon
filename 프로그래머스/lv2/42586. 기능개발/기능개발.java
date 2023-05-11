import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        Queue<Integer> fin = new LinkedList<>();
        int day = 1;
        int check = 0;


        for (int i = 0; i < progresses.length;i++){
                list.add(i,progresses[i]);
        }


        while (true){
            for (int i = 0; i < progresses.length;i++){
                if(progresses[i] + speeds[i]*day >= 100){
                    list.set(i,100);
                }
            }

            int point = check;
            if(list.get(check) == 100){
               while (true){
                   check++;
                   if(check >=list.size()){
                       break;
                   }
                   else if (list.get(check) != 100) {
                       break;
                   }
               }
               fin.add(check-point);
            }
            else{
                day++;
            }
            if(check == progresses.length){break;}
        }
        
        int[] answer = new int[fin.size()];
        for (int i = 0;i < answer.length;i++){
             answer[i] = fin.poll();
        }
        return answer;
    }
}