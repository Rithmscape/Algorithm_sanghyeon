import java.util.Arrays;
import java.util.HashMap;
class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        HashMap<String,Integer> buffer = new HashMap<>();
        for (int i = 0;i <s.length();i++){
            if(!buffer.containsKey(String.valueOf(s.charAt(i)))){
                answer[i] = -1;
                buffer.put(String.valueOf(s.charAt(i)),i);
            }
            else {
                answer[i] = i - buffer.get(String.valueOf(s.charAt(i)));
                buffer.put(String.valueOf(s.charAt(i)),i);
            }
        }
        return answer;
    }
}