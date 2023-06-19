class Solution {
    public int[] solution(String[] wallpaper) {
       Integer height_max = null;
       Integer height_min = null;
       Integer width_max = null;
       Integer width_min = null;

       for(int i =0;i < wallpaper.length;i++){
           StringBuilder stringBuilder = new StringBuilder(wallpaper[i]);
           int pos = 0;
           while (pos <wallpaper[i].length()){
               int num = stringBuilder.indexOf("#",pos);
               if (num == -1) break;

               if(height_max == null){height_max = i;}
               if(width_max == null){width_max = num;}
               if(width_min == null){width_min = num;}

               height_min = i;

               if(num>width_max){width_max =num;}
               if(num<width_min){width_min =num;}

               pos++;
           }
       }
        int[] answer = {height_max,width_min,height_min+1,width_max+1};
        return answer;
    }
}