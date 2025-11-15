import java.util.*;
import java.text.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> timeMap = new HashMap<>();
        Map<String, String> inCar = new HashMap<>();
        
        // 1. records 순회하면서 번호와 누적시간 구하기 
        for(String rec : records) {
            String time = rec.split(" ")[0];
            String car = rec.split(" ")[1];
            String inOut = rec.split(" ")[2];
            
            if(inOut.equals("IN")) {
                inCar.put(car, time);
            }
            else {
                String inTime = inCar.get(car);
                int diff = timeCalculate(inTime, time);
                timeMap.put(car, timeMap.getOrDefault(car, 0) + diff);
                
                inCar.remove(car);
            }
        }
        
        // 2. 출차 기록이 없는 차량도 계산
        for(String car : inCar.keySet()) {
            String inTime = inCar.get(car);
            int diff = timeCalculate(inTime, "23:59");
            timeMap.put(car, timeMap.getOrDefault(car, 0) + diff);
        }
        
        // 3. 차량번호 작은 순으로 정렬하여 요금 계산
        List<String> carFees = new ArrayList<>(timeMap.keySet());
        Collections.sort(carFees); // 기본 오름차순
        
        int[] answer = new int[carFees.size()];
        
        // timeMap에 접근하여 요금 계산 
        /*
        for(int i = 0; i < carFees.size(); i++) {
            String car = carFees.get(i);
            int totalTime = timeMap.get(car);
            
            int fee = calculatePrice(fees, totalTime);
            answer[i] = fee;
        }
        */
        
        int idx = 0;
        for(String num : carFees) {
            int totalMinutes = timeMap.get(num);
            int price = calculatePrice(fees, totalMinutes);
            answer[idx] = price;
            idx++;
        }
        
        
        return answer;
    }
    
    public int timeCalculate(String start, String end) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("HH:mm");

            Date date1 = format.parse(start);
            Date date2 = format.parse(end);

            long diff = date2.getTime() - date1.getTime();
            return (int) (diff / 60000);
        } catch (Exception e) {
            return 0;
        }
    }
    
    public int calculatePrice(int[] fees, int time) {
        int baseTime = fees[0];
        int baseFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];

        if (time <= baseTime) return baseFee;

        int extra = time - baseTime;
        int units = (extra + unitTime - 1) / unitTime; // 올림

        return baseFee + units * unitFee;
    }
}