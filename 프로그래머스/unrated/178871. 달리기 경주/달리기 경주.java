import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String,Integer> ranking = new HashMap<>();
        for (int i = 0; i < players.length;i++){
            ranking.put(players[i],i);
        }

        for (int j = 0; j < callings.length;j++){
            Integer rank = ranking.get(callings[j]);
            String bufer = players[rank-1];
            ranking.put(callings[j],rank-1);
            ranking.put(bufer,rank);
            players[rank] = bufer;
            players[rank-1] = callings[j];
        }

        return players;
    }
}