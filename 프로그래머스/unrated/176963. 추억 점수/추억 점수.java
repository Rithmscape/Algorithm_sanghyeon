import java.util.HashMap;
class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        HashMap<String,Integer> cost = new HashMap<>();
        for(int i = 0 ; i < name.length;i++){
            cost.put(name[i],yearning[i]);
        }
        for(int j = 0 ; j < photo.length;j++){
            int sum = 0;
            for(int k = 0 ; k < photo[j].length;k++){
                if(cost.containsKey(photo[j][k])== true) {
                    int point = cost.get(photo[j][k]);
                    sum = sum+ point;
                }
                else {}
            }
            answer[j] = sum;
        }
        return answer;
    }
}