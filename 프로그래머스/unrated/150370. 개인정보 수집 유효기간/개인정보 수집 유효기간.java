import java.time.LocalDate;
import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        HashMap<String,Integer> clause = new HashMap<>();

        for(int i = 0;i <terms.length;i++){
            String[] buffer  = terms[i].split(" ");
            clause.put(buffer[0], Integer.valueOf(buffer[1]));
        }
        LocalDate[] dataList = new LocalDate[privacies.length];

        for (int j = 0;j <privacies.length;j++){
            String[] buffer  = privacies[j].split(" ");

            int add = clause.get(buffer[1]);
            int[] bufferDay  = {add/12,add%12} ;
            String[] dayBuffer = buffer[0].split("\\.");
            if(Integer.parseInt(dayBuffer[1])+bufferDay[1] > 12){
                bufferDay[0] = bufferDay[0]+1;
                bufferDay[1] = bufferDay[1]-12;
            }
            dataList[j] = LocalDate.of(Integer.parseInt(dayBuffer[0])+bufferDay[0],Integer.parseInt(dayBuffer[1])+bufferDay[1],Integer.parseInt(dayBuffer[2]));
        }

        String[] todayBuffer = today.split("\\.");
        LocalDate localDay = LocalDate.of(Integer.parseInt(todayBuffer[0]),Integer.parseInt(todayBuffer[1]),Integer.parseInt(todayBuffer[2]));

        Queue<Integer>count = new LinkedList<>();
        for(int k = 0; k<dataList.length;k++){
            if(localDay.isAfter(dataList[k])|localDay.equals(dataList[k])){
              count.add(k+1);
            }
        }
        int size = count.size();
        int[] answer = new int[count.size()];
        for (int l = 0; l < size;l++ ){
            answer[l] = count.poll();
        }

        return answer;
    }
}