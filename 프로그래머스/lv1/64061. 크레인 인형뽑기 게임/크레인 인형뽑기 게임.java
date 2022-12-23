import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int layer = board.length-1;
        int position = board[layer].length-1;
        int total = 0;
        int doll = 0;
        int answer = 0;
        Stack<Integer> box = new Stack<>();

       for(int i = 0; i <= position;i++){ // 마지막 라인을 순회해서  값  더한후 0 이면  0처리 인형이 없다.
          total = total+board[layer][i];}
       if(total==0){return 0;}

        for(int j =0; j <moves.length; j++){
             doll = pickup(board,moves[j]);
             if (doll != 0){
                 if(box.size()==0){box.push(doll);}
                 else if(doll == box.peek()){
                     box.pop();answer+=2; }
                 else {box.push(doll);}
             }
        }

        return answer;
    }

    public static int pickup(int[][] board, int point ){
        for(int p = 0; p < board.length; p++ ){
            if(board[p][point-1] > 0){
                int buffer = board[p][point-1];
                board[p][point-1] = 0;
                return buffer;}
        }
        return 0;
    }
}