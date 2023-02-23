import java.util.Arrays;
import java.util.HashMap;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
Arrays.sort(lottos);
        Arrays.sort(win_nums);
        int[] answer = {0,0};
        HashMap<Integer,Integer> lotto = new HashMap<>();
        lotto.put(6,1);
        lotto.put(5,2);
        lotto.put(4,3);
        lotto.put(3,4);
        lotto.put(2,5);
        lotto.put(1,6);
        lotto.put(0,6);
        int count = 0;
        int zeroCount = 0;
        for(int i =0;i<lottos.length;i++){
            if(lottos[i] > 0){
                for (int j = 0; j <win_nums.length;j++ ){
                    if(lottos[i] == win_nums[j]){count++;}
                }
            }
            else {zeroCount++;}
        }
        answer[0] = lotto.get(count+zeroCount);
        answer[1] = lotto.get(count);
        return answer;
    }
}