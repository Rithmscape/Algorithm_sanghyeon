class Solution {
    public int solution(int[][] sizes) {
             int min = 0;
        int max = 0;
        for(int i = 0;i<sizes.length;i++){
            if(sizes[i][0] >= sizes[i][1]){
                if(sizes[i][0]>max){
                    max = sizes[i][0];
                }
                if(sizes[i][1]>min){
                    min = sizes[i][1];
                }
            }
            if(sizes[i][1] > sizes[i][0]){
                if(sizes[i][1]>max){
                    max = sizes[i][1];
                }
                if(sizes[i][0]>min){
                    min = sizes[i][0];
                }
            }
        }
        int answer = max*min;
        return answer;
    }
}