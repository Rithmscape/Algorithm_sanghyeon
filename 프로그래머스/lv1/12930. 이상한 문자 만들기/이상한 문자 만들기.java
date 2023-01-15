class Solution {
    public String solution(String s) {
    String answer = "";
        int a = 0;
        String [] buffer = s.split("");
        for(int i = 0; i < buffer.length;i++){
            if(buffer[i].equals(" ")){a=0;}
            else {
                if (a == 0 | a%2 == 0 ) { buffer[i] = buffer[i].toUpperCase(); a++;}
                else {buffer[i] = buffer[i].toLowerCase();a++;}
            }
            answer = answer+buffer[i];
          }

        return answer;
    }
}