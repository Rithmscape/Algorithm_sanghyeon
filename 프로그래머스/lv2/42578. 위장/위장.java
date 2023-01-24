import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
          int answer = clothes.length;
        if(answer > 1){
            HashMap<String,Integer> clt = new HashMap<>();

            int buffer = 1;

            for(int i = 0; i < clothes.length;i++) {
                if (!clt.containsKey(clothes[i][1])) {
                    clt.put(clothes[i][1], 1);
                } else {
                    clt.put(clothes[i][1], clt.get(clothes[i][1]) + 1);
                }
            }

            for(String key : clt.keySet()){
                buffer *= clt.get(key) + 1;
            }
            
            answer = buffer-1;
        }
        return answer ;
    }
}