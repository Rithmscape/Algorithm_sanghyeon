import java.util.Objects;
class Solution {
    public int solution(String[] babbling) {
        StringBuilder str = new StringBuilder();
        int answer = 0;
        for(int i = 0; i < babbling.length; i++){
            str = new StringBuilder(babbling[i]);
            String check = "";
            int index = 0;

            while (babbling[i].length() != index){
                char ch = str.charAt(index);
                if(Objects.equals(ch, 'a')&& 1 < str.length()-(index+1)&&!Objects.equals("aya",check)) {
                    if(Objects.equals('y', str.charAt(index+1))&&Objects.equals('a', str.charAt(index+2))){
                        index+=3;
                        check = "aya";
                    }
                    else {break;}
                }
                else if(Objects.equals(ch, 'y')&& 0 < str.length()-(index+1)&&!Objects.equals("ye",check)){
                    if(Objects.equals('e', str.charAt(index+1))){
                        index+=2;
                        check = "ye";
                    }
                    else {break;}
                }
                else if(Objects.equals(ch, 'w')&& 1 < str.length()-(index+1)&&!Objects.equals("woo",check)){
                    if(Objects.equals('o', str.charAt(index+1))&&Objects.equals('o', str.charAt(index+2))){
                        index+=3;
                        check = "woo";
                    }
                    else {break;}
                }
                else if(Objects.equals(ch, 'm')&& 0 < str.length()-(index+1)&&!Objects.equals("ma",check)){
                    if(Objects.equals('a', str.charAt(index+1))){
                        index+=2;
                        check = "ma";
                    }
                    else {break;}
                }
                else {index = 0;break;}
                if(str.length() == index){answer++;break;}
                else if (str.length() < index) {break;}

            }
        }
        return answer;
    }
}