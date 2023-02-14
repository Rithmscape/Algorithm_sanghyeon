class Solution {
    public int[] solution(int[] answers) {
  int arr1[]={1,2,3,4,5};
        int arr2[]={2,1,2,3,2,4,2,5};
        int arr3[]={3,3,1,1,2,2,4,4,5,5};
        int score[] = {0,0,0};
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        for(int i=0;i <answers.length;i++){
           if(arr1[count1] == answers[i] ){score[0] = score[0]+1;}
           if(arr2[count2] == answers[i] ){score[1] = score[1]+1;}
           if(arr3[count3] == answers[i] ){score[2] = score[2]+1;}
            count1++;
            if(count1==arr1.length){count1=0;}
            count2++;
            if(count2==arr2.length){count2=0;}
            count3++;
            if(count3==arr3.length){count3=0;}
        }

        int max = score[0];
        for(int j = 1; j < score.length;j++){
            if(max<score[j]){max=score[j];}
        }

        int index = 0;
        for(int k = 0; k < score.length;k++){
            if(max==score[k]){index++;}
        }


        int[] answer = new int[index];
        index = 0;
        for(int n = 0; n < score.length;n++){
            if(max==score[n]){
                answer[index]=n+1;
                index++;
            }
        }
        return answer;
    }
}