import java.util.Arrays;
import java.util.Objects;
class Solution {
    public int[] solution(String[] park, String[] routes) {
  StringBuilder stringBuilder =new StringBuilder();

        int[] answer = {};
        int[] start = new int[1];
        for(int i = 0; i<park.length;i++) {
            stringBuilder = new StringBuilder(park[i]);

            if (stringBuilder.indexOf("S") != -1) {
                start = new int[]{i, park[i].indexOf("S")};
                break;
            }

        }
        int[] now = start;

        for(int j =0; j < routes.length;j++){
            stringBuilder = new StringBuilder(routes[j]);
            int[] direction = {stringBuilder.charAt(0),stringBuilder.charAt(2)-48};

            now = move(direction,now,park);
        }

        answer = now;
        return answer;
    }


    public static boolean check (int[] togo, String[] park){
        if(togo[0] >= park.length || togo[1] >= park[0].length()){return false;}
        else if(togo[0] < 0 || togo[1] < 0){return false;}
        else if (park[togo[0]].charAt(togo[1]) == 'X'){return false;}
        return true;
    }

    public static int[] move (int[] direction ,int[] now, String[] park) {
        int[] togo = now;
        if (direction[0] == 78) {
            int loop = 0;
            while (loop < direction[1]){
                loop++;
                togo = new int[]{togo[0] - 1, togo[1]};
                if (!check(togo,park)){return now;}
            }
        } else if (direction[0] == 83) {
            int loop = 0;
            while (loop < direction[1]){
                loop++;
                togo = new int[]{togo[0]+1, togo[1]};
                if (!check(togo,park)){return now;}
            }
        } else if (direction[0] == 87) {
            int loop = 0;
            while (loop < direction[1]){
                loop++;
                togo = new int[]{togo[0], togo[1]-1};
                if (!check(togo,park)){return now;}
            }

        } else if (direction[0] == 69) {
            int loop = 0;
            while (loop < direction[1]){
                loop++;
                togo = new int[]{togo[0], togo[1] + 1};
                if (!check(togo,park)){return now;}
            }
        }

        return togo;
    }
}