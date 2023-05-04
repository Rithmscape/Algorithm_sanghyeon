import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
      int answer = 0;

        if (cacheSize == 0){return cities.length*5;}
        Queue<String> citys = new LinkedList<>();

        for (int i = 0; i < cities.length; i++){
            String city = cities[i].toLowerCase();
            if(citys.contains(city)){
                answer++;
                int a = citys.size();
                for(int j = 0; j < a;j++){
                    String buffer = citys.poll();
                    if(!Objects.equals(buffer, city)){
                        citys.add(buffer);
                    }
                }
                citys.add(city);
            }
            else {
                if(citys.size() >= cacheSize){
                    citys.add(city);
                    citys.poll();
                    answer += 5;
                }
                else {
                    citys.add(city);
                    answer += 5;
                }
            }
        }
        return answer;
    }
}