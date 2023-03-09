import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
         List<String> list = new ArrayList<>();
        for (int i = goal.length-1; i >= 0; i--) {
            list.add(goal[i]);
        }
        Deque<String> deque = new ArrayDeque<>(list);

        int count1 = 0;
        int count2 = 0;

        while(!deque.isEmpty()) {
            if(Objects.equals(cards1[count1], deque.peekLast())) {
                deque.pollLast();
                if(cards1.length>count1+1 ){count1++;}
            }
            else if(Objects.equals(cards2[count2], deque.peekLast())) {
                deque.pollLast();
                if(cards2.length>count2+1 ){count2++;}
            }
            else {return "No";}
        }
        return "Yes";
    }
}