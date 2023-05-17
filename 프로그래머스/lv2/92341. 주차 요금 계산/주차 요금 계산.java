import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
  HashMap<Integer,Integer> carList =new HashMap<>();
        HashMap<Integer,Integer> cost =new HashMap<>();
        List<Integer> cars = new ArrayList<>();
        Deque<Integer> parkingCar = new ArrayDeque<>();
        StringBuilder stringBuilder =new StringBuilder();

        for (int i = 0;i< records.length;i++) {
            stringBuilder = new StringBuilder(records[i]);
            int indexCar = stringBuilder.indexOf(" ");
            int indexInout = stringBuilder.lastIndexOf(" ");

            Integer carNum = Integer.valueOf(stringBuilder.substring(indexCar + 1, indexInout));
            Integer time = (Integer.valueOf(stringBuilder.substring(0, 2)) * 60) + Integer.valueOf(stringBuilder.substring(3, 5));



            if (stringBuilder.charAt(indexInout + 1) == 'I') {

                if(carList.containsKey(carNum)){
                    carList.put(carNum, time);
                    parkingCar.add(carNum);
                }
                else {
                    carList.put(carNum, time);
                    parkingCar.add(carNum);
                    cars.add(carNum);
                }


            } else {
                time = time - carList.get(carNum);

                if(cost.containsKey(carNum)){
                    cost.put(carNum, cost.get(carNum)+time);
                    parkingCar.remove(carNum);
                }
                else {
                    cost.put(carNum,time);
                    parkingCar.remove(carNum);
                }
            }
        }


        while (parkingCar.size()>0){
            int car = parkingCar.poll();
            int LastTime = 1439 - carList.get(car);
            if(cost.containsKey(car)){
                cost.put(car, cost.get(car)+LastTime);
            }
            else {
                cost.put(car, LastTime);
            }
        }

        int[] answer = new int[cost.size()];
        int index = 0;

        Collections.sort(cars);
        for(int j =0;j < cars.size();j++){
            int times = cost.get(cars.get(j))-fees[0];
            if(times <0 ){times=0;}
            int money = 0;
            if(times%fees[2] != 0){
                money = fees[1]+(times/fees[2]+1)*fees[3];
            }
            else {
                money = fees[1]+(times/fees[2])*fees[3];
            }
            answer[j] = money;
        }

        return answer;
    }
}