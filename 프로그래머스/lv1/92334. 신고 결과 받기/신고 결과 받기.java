import java.util.*;
import java.util.stream.Collectors;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        int[] count = new int[id_list.length];

        HashMap<String, ArrayList<String>> id_pick = new HashMap<>();
        HashMap<String,Integer >id_count = new HashMap<>();

        List<String> ReSetReport = Arrays.asList(report)
                .stream()
                .distinct()
                .collect(Collectors.toList());


       for(int i = 0; i < ReSetReport.size();i++){
           String[] arr = ReSetReport.get(i).split(" ");
           for(int j = 0 ; j < id_list.length;j++){
               if(Objects.equals(arr[1], id_list[j])){count[j] = count[j] + 1;}

               if(Objects.equals(arr[0], id_list[j])){
                   ArrayList<String> buffer = new ArrayList<>();
                   if(id_pick.get(arr[0]) != null){
                       buffer = id_pick.get(arr[0]);
                       buffer.add(arr[1]);
                   }
                   else {buffer.add(arr[1]);}
                   id_pick.put(arr[0],buffer);
               }
           }
       }

       for(int j = 0; j<id_list.length;j++){
           id_count.put(id_list[j],count[j]);
       }


       for(int n = 0; n < id_list.length;n++ ){
           if(id_pick.get(id_list[n]) == null){}
           else if(id_pick.get(id_list[n]) != null) {
               for(int l = 0; l<id_pick.get(id_list[n]).size();l++){
                   if (id_count.get(id_pick.get(id_list[n]).get(l)) >= k){
                       answer[n] = answer[n]+1;
                   }

               }
           }
       }

        return answer;
    }
}