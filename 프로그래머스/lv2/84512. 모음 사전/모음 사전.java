import java.util.HashMap;
class Solution {
    public int solution(String word) {
        int answer = word.length();
        int count = 0;
        int[] arr = {781,156,31,6,1};
        HashMap<Character,Integer> list = new HashMap<>();
        list.put('A',0);
        list.put('E',1);
        list.put('I',2);
        list.put('O',3);
        list.put('U',4);

        for(int i = 0; i <word.length();i++){
            answer = answer+arr[count]*list.get(word.charAt(i));
            count++;
        }
        return answer;
    }
}