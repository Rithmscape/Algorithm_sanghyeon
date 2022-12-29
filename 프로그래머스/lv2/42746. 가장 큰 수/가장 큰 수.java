import java.util.Collections;
import java.util.PriorityQueue;
class Solution {
    public String solution(int[] numbers) {
     String answer ="";
        PriorityQueue<Integer> num9 = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> num99 = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> num999 = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> num1000 = new PriorityQueue<>(Collections.reverseOrder());
        Integer buffer = null;
        Integer ten = 0;
        Integer num1 = null;
        Integer num2 = null;

        long nums = 0;
        for(int i= 0; i <numbers.length;i++){
             if(numbers[i]<10){num9.add(numbers[i]);}
             else if(numbers[i]<100){num99.add(numbers[i]);}
             else if(numbers[i]<1000){num999.add(numbers[i]);}
             else if(numbers[i]<10000){num1000.add(numbers[i]);}
        }

        while (num9.size() !=0 | num99.size()!=0 | num999.size()!=0 | num1000.size()!=0 ){

            //0 ~ 9
            if(num9.size() !=0){buffer = num9.peek();ten = 1;}

            //10 ~ 99

            if(num99.size() !=0){
                if(buffer == null) {buffer = num99.peek();ten = 10;}

                else if(ten == 1){
                    if(buffer < (num99.peek()/10)) { buffer = num99.peek();ten = 10;}
                    else if(buffer == (num99.peek()/10)) {
                        num1 = Integer.valueOf(String.valueOf(buffer)+num99.peek());
                        num2 = Integer.valueOf(String.valueOf(num99.peek())+buffer);
                        if(num1 < num2){
                            buffer = num99.peek();ten = 10;
                        }
                    }
                }
            }

            //100 ~ 999
            if(num999.size() !=0) {

               if (buffer == null) {buffer = num999.peek();ten = 100;}

               else if (ten == 10) {
                   if (buffer < (num999.peek() / 10)) {buffer = num999.peek();ten = 100;}
                   else if (buffer == (num999.peek() / 10)) {
                       num1 = Integer.valueOf(String.valueOf(buffer) + num999.peek());
                       num2 = Integer.valueOf(String.valueOf(num999.peek()) + buffer);
                       if (num1 < num2) {buffer = num999.peek();ten = 100;}
                   }
               }

               else if (ten == 1) {
                   if (buffer < (num999.peek() / 100)) {buffer = num999.peek();ten = 100;}
                   else if (buffer == (num999.peek() / 100)) {
                       num1 = Integer.valueOf(String.valueOf(buffer) + num999.peek());
                       num2 = Integer.valueOf(String.valueOf(num999.peek()) + buffer);
                       if (num1 < num2) {buffer = num999.peek();ten = 100;}
                   }
               }

            }

            if(num1000.size() !=0 && buffer == null | buffer < (num1000.peek()/1000)){buffer = num1000.peek();ten = 1000;}


            if(ten == 1){if(answer.equals("0")){answer = "0";num9.poll();} else{answer= answer+String.valueOf(num9.poll());}}
            else if (ten == 10) {answer= answer+String.valueOf(num99.poll());}
            else if (ten == 100) {answer= answer+String.valueOf(num999.poll());}
            else if (ten == 1000) {answer= answer+String.valueOf(num1000.poll());}
            buffer = null; ten = 0;
        }
        return answer;
    }
}