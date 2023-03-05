import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
 List<Integer> list = new ArrayList<>();
        Arrays.sort(people);
        for (int i = people.length-1; i >= 0; i--) {
            list.add(people[i]);
        }
        int count = 0;
        Deque<Integer> deque = new ArrayDeque<>(list);

        while(!deque.isEmpty()) {
            int sum = deque.peekFirst() + deque.peekLast();
            if(sum > limit) {
                deque.pollFirst();
                count++;
            } else {
                deque.pollFirst();
                deque.pollLast();
                count++;
            }

        }

        if(!deque.isEmpty()) {
            count += deque.size();
        }
        return count;
    }
}