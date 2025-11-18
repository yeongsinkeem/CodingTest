import java.util.*;
 
class Solution {
    static final int[] DISCOUNTS = {10, 20, 30, 40};
    
    int[][] users;
    int[] emoticons;
    
    // 현재 탐색 중인 이모티콘들의 할인율
    int[] currDiscounts;
    
    // 최대 서비스 가입 유저
    int maxPlusTotal = Integer.MIN_VALUE;
    // 최대 이모티콘 판매액 
    int maxUserTotal = Integer.MIN_VALUE;
    
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        
        this.users = users;
        this.emoticons = emoticons;
        this.currDiscounts = new int[emoticons.length];
        
        // 1. DFS로 각 이모티콘의 할인율 저장
        DFS(0);
        
        answer[0] = maxPlusTotal;
        answer[1] = maxUserTotal;
        
        return answer;
    }
    
    // 2. DFS로 전체 조합 구하기 
    public void DFS(int depth) {
        if( depth == emoticons.length ) {
            // 구매 비용 및 서비스 가입 여부 구하기
            calculateUser();
            return; 
        }
        
        for(int i = 0; i < 4; i++) {
            currDiscounts[depth] = DISCOUNTS[i];
            DFS(depth + 1);
        }
    }
    
    // 3. 해당 할인 조합일 때 사용자별 구매 비용 및 서비스 가입 여부 구하기 
    public void calculateUser() {
        int userTotal = 0; // 판매액 
        int plusTotal = 0; // 이모티콘 플러스 가입자 수
        
        // 사용자 순회하면서 이모티콘 값 계산
        for(int[] user : users) {
            int userRate = user[0];
            int userLimit = user[1];
            int userSum = 0; // 구매 총액 
            
            // 이모티콘 순회하면서
            // 할인율 적용 및 계산 
            for(int i = 0; i < emoticons.length; i++) {
                // 할인율이 더 크다면 구매 
                if (userRate <= currDiscounts[i]) {
                    userSum += emoticons[i] * (100 - currDiscounts[i]) / 100;
                }
            }
            
            if( userSum >= userLimit ) {
                plusTotal++;
            } else {
                userTotal += userSum;
            }
        }
        
        if( plusTotal > maxPlusTotal ) {
            maxPlusTotal = plusTotal;
            maxUserTotal = userTotal;
        }
        
        // 가입자 수가 같아면 매출액 증가 
        else if( plusTotal == maxPlusTotal ) {
            maxUserTotal = Math.max(maxUserTotal, userTotal);
        }
    }
}