import java.util.*;

public class Solution {
    public int solution(int n) {
        String str = n+"";
        int answer = 0;
        str =  str.replaceAll("0","");
        for (int i = 1; i<10;i++){
            int len = str.length();
            str =  str.replaceAll(i+"","");
            answer = answer+((len-str.length())*i);
        }
        return answer;
    }
}