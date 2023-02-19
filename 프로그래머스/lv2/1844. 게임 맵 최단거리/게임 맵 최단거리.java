import java.util.Queue;
import java.util.LinkedList;
class Solution {
    public int solution(int[][] maps) {
         int[][] check = new int[maps.length][maps[0].length];

        check[0][0] = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});


        while (!queue.isEmpty()){
            int[] point = queue.poll();

            if(point[0]== maps.length-1&&point[1]==maps[0].length-1){
                return check[maps.length-1][maps[0].length-1];
            }

            if(point[0]+1 < maps.length && maps[point[0]+1][point[1]] == 1 && check[point[0]+1][point[1]] == 0) {
                queue.add(new int[] {point[0]+1, point[1]});
                check[point[0]+1][point[1]] += check[point[0]][point[1]] + 1;
            }
            if(point[0] > 0 && maps[point[0]-1][point[1]] == 1 && check[point[0]-1][point[1]] == 0) {
                queue.add(new int[] {point[0]-1, point[1]});
                check[point[0]-1][point[1]] += check[point[0]][point[1]] + 1;
            }
            if(point[1]+1 < maps[0].length && maps[point[0]][point[1]+1] == 1 && check[point[0]][point[1]+1] == 0) {
                queue.add(new int[] {point[0], point[1]+1});
                check[point[0]][point[1]+1] += check[point[0]][point[1]] + 1;
            }
            if(point[1] > 0 && maps[point[0]][point[1]-1] == 1 && check[point[0]][point[1]-1] == 0) {
                queue.add(new int[] {point[0], point[1]-1});
                check[point[0]][point[1]-1] += check[point[0]][point[1]] + 1;
            }
        }

        return -1;
    }
}