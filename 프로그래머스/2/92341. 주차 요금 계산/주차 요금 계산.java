import java.util.*;

class Solution {
    static String in = "IN";
    static String out = "OUT";
    
    public int[] solution(int[] fees, String[] records) {
        
        // 1. 입차 map 생성
        Map<String, String> inCarMap = new HashMap<>();
        
        // 2. 총 주차 시간 map 생성
        Map<String, Integer> totalTimeMap = new HashMap<>();
        
        // 3. records 순회하면서 IN -> 입차 map에 넣기
        for(String rec : records) {
            // 입차량이라면 -> 입차 map에 넣기
            if( rec.split(" ")[2].equals(in) ) {
                String inCarNum = rec.split(" ")[1];
                String inCarTime = rec.split(" ")[0];
                inCarMap.put(inCarNum, inCarTime);
            }
            
            // 출차량이라면 -> 시간 계산 후 입차 map에서 제거 
            else {
                String outCarNum = rec.split(" ")[1];
                
                String inCarTime = inCarMap.get(outCarNum);
                String outCarTime = rec.split(" ")[0];
                
                int totalTime = calculateTime(inCarTime, outCarTime);
                totalTimeMap.put(outCarNum, totalTimeMap.getOrDefault(outCarNum, 0) + totalTime);
                inCarMap.remove(outCarNum);
            }
        }
        
        // 4. 만약 입차량에 차량이 남아있다면 23:59로 계산
        for( String inCar : inCarMap.keySet() ) {
            String inCarTime = inCarMap.get(inCar);
            String endTime = "23:59";
                
            int totalTime = calculateTime(inCarTime, endTime);
            totalTimeMap.put(inCar, totalTimeMap.getOrDefault(inCar, 0) + totalTime);
        }
        
        List<String> carLst = new ArrayList<>(totalTimeMap.keySet());
        Collections.sort(carLst);
        int[] answer = new int[carLst.size()];
        
        int idx = 0;
        
        // fees[0] = 기본 시간
        // fees[1] = 기본 요금
        // fees[2] = 단위 시간
        // fees[3] = 단위 요금 
        for(String car : carLst) {
            int totalTime = totalTimeMap.get(car);
            int totalPrice = 0;
            
            // 기본시간 넘는다면
            if( totalTime > fees[0] ) {
                int extraTime = (totalTime - fees[0]) / fees[2];
                // 올림 처리 
                if( (totalTime - fees[0]) % fees[2] != 0 ) extraTime++;
                
                extraTime *= fees[3];
                
                totalPrice = fees[1] + extraTime;
            }
            
            // 기본시간 넘지 않는다면
            else {
                totalPrice = fees[1];
            }
            answer[idx] = totalPrice;
            idx++;
        }
        
        return answer;
    }
    
    public int calculateTime(String start, String end) {
        String[] startTime = start.split(":");
        int startHour = Integer.parseInt(startTime[0]);
        int startMinute = Integer.parseInt(startTime[1]);
        int startTotalTime = startHour * 60 + startMinute;
        
        String[] endTime = end.split(":");
        int endHour = Integer.parseInt(endTime[0]);
        int endMinute = Integer.parseInt(endTime[1]);
        int endTotalTime = endHour * 60 + endMinute;
        
        return endTotalTime - startTotalTime;
    }
}