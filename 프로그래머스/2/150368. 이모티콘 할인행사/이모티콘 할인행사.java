import java.util.*;

class Solution {
    
    // 1. 모든 조합을 탐색하며 찾은 최적의 답을 저장할 전역 변수
    static int maxSubscribers = 0; // 1순위 목표: 최대 가입자 수
    static int maxSales = 0;       // 2순위 목표: 최대 판매액
    
    // 할인율은 10, 20, 30, 40% 네 가지 경우만 존재
    static int[] discountRates = {10, 20, 30, 40};
    
    // users와 emoticons 정보를 다른 메서드에서도 사용하기 위해 전역 변수로 선언
    static int[][] globalUsers;
    static int[] globalEmoticons;

    public int[] solution(int[][] users, int[] emoticons) {
        
        // 전역 변수 초기화 (테스트 케이스가 여러 개일 경우를 대비)
        maxSubscribers = 0;
        maxSales = 0;
        globalUsers = users;
        globalEmoticons = emoticons;

        // DFS 탐색을 위한 배열 (각 이모티콘에 적용된 할인율을 저장)
        // 예: [10, 40, 20, 10]
        int[] currentDiscounts = new int[emoticons.length];
        
        // 1. DFS 시작 (0번째 이모티콘부터 할인율을 정해나감)
        dfs(0, currentDiscounts);

        // 탐색이 모두 끝난 뒤, 저장된 최적의 답 반환
        return new int[]{maxSubscribers, maxSales};
    }

    /**
     * 1단계: 모든 할인율 조합 만들기 (DFS)
     * @param index - 현재 할인율을 결정해야 하는 이모티콘의 인덱스
     * @param discounts - 현재까지 결정된 할인율 조합 배열
     */
    public void dfs(int index, int[] discounts) {
        
        // [기저 조건] : 모든 이모티콘의 할인율을 다 정했다면 (index가 이모티콘 개수와 같아진다면)
        if (index == globalEmoticons.length) {
            // 2. 이 할인율 조합으로 시뮬레이션 실행
            calculateResult(discounts);
            return; // 현재 재귀 호출 종료
        }

        // [재귀] : 현재 index의 이모티콘에 4가지 할인율을 각각 적용해본다
        for (int rate : discountRates) {
            discounts[index] = rate;      // rate를 현재 이모티콘에 적용
            dfs(index + 1, discounts); // 다음 이모티콘(index + 1)의 할인율을 정하러 이동
        }
    }

    /**
     * 2단계: 각 조합별로 결과 시뮬레이션
     * @param discounts - DFS로 완성된 하나의 할인율 조합 (예: [10, 40, 20])
     */
    public void calculateResult(int[] discounts) {
        
        int currentCaseSubscribers = 0; // 이번 조합의 가입자 수
        int currentCaseSales = 0;       // 이번 조합의 판매액 (가입자 제외)

        // 모든 유저를 순회
        for (int[] user : globalUsers) {
            int userMinDiscountRate = user[0]; // 유저의 최소 할인율 기준
            int userMaxPrice = user[1];        // 유저의 최대 구매액 (이모티콘 플러스 기준)
            
            int userPurchaseAmount = 0; // 이 유저 한 명의 총 구매액

            // 모든 이모티콘을 순회하며 이 유저가 구매할지 확인
            for (int i = 0; i < globalEmoticons.length; i++) {
                
                // 이모티콘의 할인율(discounts[i])이 유저의 기준(userMinDiscountRate) 이상이면 구매
                if (discounts[i] >= userMinDiscountRate) {
                    // 할인된 가격을 계산하여 총 구매액에 더함
                    userPurchaseAmount += globalEmoticons[i] * (100 - discounts[i]) / 100;
                }
            }

            // 이 유저가 플러스 가입하는지, 그냥 구매하는지 확인
            if (userPurchaseAmount >= userMaxPrice) {
                currentCaseSubscribers++; // 기준액을 넘었으므로 가입!
            } else {
                currentCaseSales += userPurchaseAmount; // 기준액을 못 넘었으므로 구매!
            }
        }

        // 3. 이 조합의 결과로 최적의 답 갱신
        updateAnswer(currentCaseSubscribers, currentCaseSales);
    }

    /**
     * 3단계: 최적의 답 갱신
     * @param newSubs - 이번 조합(calculateResult)에서 나온 가입자 수
     * @param newSales - 이번 조합(calculateResult)에서 나온 판매액
     */
    public void updateAnswer(int newSubs, int newSales) {
        
        // 1순위: 가입자 수가 더 많으면 무조건 갱신
        if (newSubs > maxSubscribers) {
            maxSubscribers = newSubs;
            maxSales = newSales;
        } 
        // 2순위: 가입자 수가 같은 경우, 판매액이 더 많을 때만 갱신
        else if (newSubs == maxSubscribers) {
            if (newSales > maxSales) {
                maxSales = newSales;
                // maxSales = Math.max(maxSales, newSales); 와 동일
            }
        }
    }
}