class Solution {
    public String solution(String s, String skip, int index) {
          StringBuilder answer = new StringBuilder(s);
        for (int i =0; i <s.length();i++){
            int buffer = (int) s.charAt(i);

            for (int k = index;k >0 ; k--){
                buffer = buffer+1;
                if(buffer > 122 ){buffer = buffer-26;}
                for(int j = 0;j<skip.length();j++){
                    if(buffer==skip.charAt(j)){k++;}
                    if(buffer == 122 && index == 1 &&skip.charAt(j) == 97){
                        k++;
                    }

                }
            }

            answer.setCharAt(i, (char) buffer);
        }
        return String.valueOf(answer);
    }
}