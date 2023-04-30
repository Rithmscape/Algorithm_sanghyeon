import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> mandarin  = new HashMap<>();

        for(int t:tangerine){
            mandarin.put(t,mandarin.getOrDefault(t, 0)+1);
        }
        List<Integer> list = new ArrayList<>(mandarin.values());
        Collections.sort(list, Collections.reverseOrder());
        for(Integer a:list){
            k-=a;
            answer++;
            if(k<1){
                return answer;
            }
        }

        return answer;
    }
}