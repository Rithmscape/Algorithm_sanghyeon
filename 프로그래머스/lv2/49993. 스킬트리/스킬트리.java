class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        String[] arr =  skill.split("");

        for (int i =0; i < skill_trees.length;i++) {
            int current = -1;
            int check = 0;
            for (int j = 0; j < arr.length;j++){
                int index = skill_trees[i].indexOf(arr[j]);


                 if(index != -1 &&index<current){
                     break;
                 }
                 else if (j != check &&index > current) {
                     break;
                 }
                 else if(j == check &&index > current){
                     current = index;
                     check++;
                 }
                if(j == arr.length-1){
                    answer++;
                }
            }
        }
        return answer;
    }
}