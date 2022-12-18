import java.util.Objects;

class Solution {
    public int solution(String s) {
        int answer = 0;
               String[] str = s.split("");
        String ant = "";
        for(int i = 0; i< s.length(); i++){
            if(Objects.equals(str[i], "z")) {
                i = i + 3;
                ant = ant + "0";
            }
            else if(Objects.equals(str[i], "o")) {
                i = i + 2;
                ant = ant + "1";
            }
            else if(Objects.equals(str[i], "t")) {
               if(Objects.equals(str[i+1], "w")) {
                   i = i + 2;
                   ant = ant + "2";
               }
                if(Objects.equals(str[i+1], "h")) {
                    i = i + 4;
                    ant = ant + "3";
                }
            }
            else if(Objects.equals(str[i], "f")) {
                if(Objects.equals(str[i+1], "o")) {
                    i = i + 3;
                    ant = ant + "4";
                }
                if(Objects.equals(str[i+1], "i")) {
                    i = i + 3;
                    ant = ant + "5";
                }
            }
            else if(Objects.equals(str[i], "s")) {
                if(Objects.equals(str[i+1], "i")) {
                    i = i + 2;
                    ant = ant + "6";
                }
                if(Objects.equals(str[i+1], "e")) {
                    i = i + 4;
                    ant = ant + "7";
                }
            }
            else if(Objects.equals(str[i], "e")) {
                i = i + 4;
                ant = ant + "8";
            }

            else if(Objects.equals(str[i], "n")) {
                i = i + 3;
                ant = ant + "9";
            }
            else {ant = ant+str[i];}
        }
        answer = Integer.parseInt(ant);
        return answer;
    }
}