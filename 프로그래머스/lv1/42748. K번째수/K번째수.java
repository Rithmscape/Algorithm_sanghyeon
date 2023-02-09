import java.util.Arrays;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i =0; i<commands.length;i++){
            int[] buffer = new int[commands[i][1]-commands[i][0]+1];
            System.arraycopy(array,commands[i][0]-1,buffer,0,buffer.length);
            Arrays.sort(buffer);
            answer[i] = buffer[commands[i][2]-1];
        }
        return answer;
    }
}