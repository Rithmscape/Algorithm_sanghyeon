import java.util.Arrays;
import java.util.Objects;
class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
               String[] answer = new String[n];
        long[] sum = new long[arr1.length];
        String buffer = "";

        for(int i = 0;i <arr1.length;i++){
            sum[i] = Long.parseLong(Long.toBinaryString(arr1[i]))+Long.parseLong(Long.toBinaryString(arr2[i]));
        }

        for(int j = 0; j < sum.length; j++ ) {
            buffer = sum[j]+"";

            //n자리로 만들기
            while (buffer.length() < n ){
                buffer = "0"+buffer;
            }
            buffer = buffer.replaceAll("1" ,"#");
            buffer = buffer.replaceAll("2","#");
            buffer = buffer.replaceAll("0"," ");
            answer[j] = buffer;
        }


        return answer;
    }
}