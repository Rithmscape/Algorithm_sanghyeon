import java.util.*;

class Solution {
    public String solution(int[] numbers) {
      String answer ="";
        PriorityQueue<Integer> num9 = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> num99 = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> num999 = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> num9999 = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> num99999 = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> num100000 = new PriorityQueue<>(Collections.reverseOrder());
        Integer buffer = null;
        Integer ten = 0;
        Integer num1 = null;
        Integer num2 = null;

        long nums = 0;
        for(int i= 0; i <numbers.length;i++){
             if(numbers[i]<10){num9.add(numbers[i]);}
             else if(numbers[i]<100){num99.add(numbers[i]);}
             else if(numbers[i]<1000){num999.add(numbers[i]);}
             else if(numbers[i]<10000){num9999.add(numbers[i]);}
             else if(numbers[i]<100000){num99999.add(numbers[i]);}
             else if(numbers[i]==100000){num100000.add(numbers[i]);}
        }


        while (num9.size() !=0 | num99.size()!=0 | num999.size()!=0 | num9999.size()!=0 | num99999.size()!=0| num100000.size()!=0){

            //0 ~ 9
            if(num9.size() !=0){buffer = num9.peek();ten = 1;}

            //10 ~ 99

            if(num99.size() !=0 && (buffer == null |ten == 1)){
                if(buffer == null) {buffer = num99.peek();ten = 10;}
                else if(buffer < (num99.peek()/10)){buffer = num99.peek();ten = 10;}
            }

            //100 ~ 999
            if(num999.size() !=0 && buffer == null | ten == 10){
                if(buffer == null) {buffer = num999.peek();ten = 100;}

                if(buffer < (num999.peek()/10)){buffer = num999.peek();ten = 100;}
                else if(buffer == (num999.peek()/10)){
                    num1 = Integer.valueOf(String.valueOf(buffer)+num999.peek());
                    num2 = Integer.valueOf(String.valueOf(num999.peek())+buffer);
                    if(num1 < num2){
                        buffer = num999.peek();ten = 100;
                    }
                }
            }
            else if(num999.size() !=0 && ten == 1){
                if(buffer < (num999.peek()/100)){buffer = num999.peek();ten = 100;}
            }


            //1000 ~ 9999
            if(num9999.size() !=0 && buffer == null | ten == 100){
                if(buffer == null) {buffer = num9999.peek();ten = 1000;}

                if(buffer < (num9999.peek()/10)){buffer = num9999.peek();ten = 1000;}
                else if(buffer == (num9999.peek()/10)){
                    num1 = Integer.valueOf(String.valueOf(buffer)+num9999.peek());
                    num2 = Integer.valueOf(String.valueOf(num9999.peek())+buffer);
                    if(num1 < num2){
                        buffer = num9999.peek();ten = 1000;
                    }
                }
            }
            else if(num9999.size() !=0 && ten == 10) {
                if (buffer < (num9999.peek() / 100)) {buffer = num9999.peek();ten = 1000;}
                else if (buffer == (num9999.peek() / 100)) {
                    num1 = Integer.valueOf(String.valueOf(buffer)+num9999.peek());
                    num2 = Integer.valueOf(String.valueOf(num9999.peek())+buffer);
                    if(num1 < num2){
                        buffer = num9999.peek();ten = 1000;
                    }
                }
            }
            else if(num9999.size() !=0 && ten == 1){
                if (buffer < (num9999.peek() / 1000)) {buffer = num9999.peek();ten = 1000;}
            }


            //10000 ~ 99999
            if(num99999.size() !=0 && buffer == null | ten == 1000){
                if(buffer == null) {buffer = num99999.peek();ten = 10000;}

                if (buffer < (num99999.peek() / 10)) {buffer = num99999.peek();ten = 10000;}
                else if (buffer == (num99999.peek() / 10)) {
                    num1 = Integer.valueOf(String.valueOf(buffer)+num99999.peek());
                    num2 = Integer.valueOf(String.valueOf(num99999.peek())+buffer);
                    if(num1 < num2){
                        buffer = num99999.peek();ten = 10000;
                    }
                }
            }


            else if(num99999.size() !=0 && ten == 100){
                if (buffer < (num99999.peek() / 100)) {buffer = num99999.peek();ten = 10000;}
                else if (buffer == (num99999.peek() / 100)) {
                    num1 = Integer.valueOf(String.valueOf(buffer)+num99999.peek());
                    num2 = Integer.valueOf(String.valueOf(num99999.peek())+buffer);
                    if(num1 < num2){
                        buffer = num99999.peek();ten = 10000;
                    }
                }
            }
            else if(num99999.size() !=0 && ten == 10){
                if (buffer < (num99999.peek() / 1000)) {buffer = num99999.peek();ten = 10000;}
                else if (buffer == (num99999.peek() / 1000)) {
                    num1 = Integer.valueOf(String.valueOf(buffer)+num99999.peek());
                    num2 = Integer.valueOf(String.valueOf(num99999.peek())+buffer);
                    if(num1 < num2){
                        buffer = num99999.peek();ten = 10000;
                    }
                }
            }
            else if(num99999.size() !=0 && ten == 1){
                if (buffer < (num99999.peek() / 10000)) {buffer = num99999.peek();ten = 10000;}
            }

            if(num100000.size() !=0 && buffer == null | buffer < (num100000.peek()/100000)){buffer = num100000.peek();ten = 100000;}


            if(ten == 1){ answer= answer+String.valueOf(num9.poll());}
            else if (ten == 10) {answer= answer+String.valueOf(num99.poll());}
            else if (ten == 100) {answer= answer+String.valueOf(num999.poll());}
            else if (ten == 1000) {answer= answer+String.valueOf(num9999.poll());}
            else if (ten == 10000) {answer= answer+String.valueOf(num99999.poll());}
            else if (ten == 100000) {answer= answer+String.valueOf(num100000.poll());}
            buffer = null; ten = 0;
        }
        return answer;
    }
}