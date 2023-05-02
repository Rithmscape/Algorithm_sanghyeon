import java.util.*;
class Solution {
    public int solution(int[] nums) {
            int lang = nums.length/2;
        HashSet<Integer> list = new HashSet<>();
        for(int i = 0; i < nums.length;i++){
            list.add(nums[i]);
        }
        if(list.size() > lang){
            return lang;
        }
        else {return list.size();}
    }
}