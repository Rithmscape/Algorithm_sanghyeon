import java.util.*;

class Solution {
    public static int solution(int k, int[][] dungeons) {
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[dungeons.length];
        dfs(dungeons,k, visited, 0,list);
        list.sort(Comparator.reverseOrder());
        return list.get(0);
    }

    public static void dfs(int[][] dungeons, int k,boolean[] visited, int depth, List<Integer> list) {

        for(int j = 0; j < dungeons.length; j++) {
            if(!visited[j] && k >= dungeons[j][0]) {
                visited[j] = true;
                dfs(dungeons, k - dungeons[j][1], visited, depth+1, list);
                visited[j] = false;
            }
        }
        list.add(depth);
    }
}