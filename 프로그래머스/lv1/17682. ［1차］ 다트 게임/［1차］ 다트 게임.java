class Solution {
    public int solution(String dartResult) {
 int answer = 0;
        int num = 0;
        int numCount = 0;
        Integer[] nums = {null,null,null};
        String[]  symbol = {"+","+"};
        for (int i= 0; i<dartResult.length();i++){
            int cha = (int)dartResult.charAt(i);

            if (cha>47&&cha<58){
                num = dartResult.charAt(i)-48;
                if(i !=0){if(cha==48 && dartResult.charAt(i-1) == 49){num =10;}}
            }
            else if(numCount==1&&dartResult.charAt(i)==42){nums[0] = nums[0]*2;}
            else if(numCount>1&&dartResult.charAt(i)==42){
                nums[numCount-2] = nums[numCount-2]*2;
                nums[numCount-1] = nums[numCount-1]*2;
            }
            else if(dartResult.charAt(i)==35){
                nums[numCount-1] = nums[numCount-1]*-1;
            }

            else {
                if(dartResult.charAt(i)==83){//S
                    num = num * 1;
                }
                else if(dartResult.charAt(i)==68){//D
                    num = num * num;
                }
                else if(dartResult.charAt(i)==84){//T
                    num = num * num *num;
                }
                nums[numCount] = num;
                numCount++;
            }
        }
        answer= nums[0]+nums[1]+nums[2];


        return answer;
    }
}