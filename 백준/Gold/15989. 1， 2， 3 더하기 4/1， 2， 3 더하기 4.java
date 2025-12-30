import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 문제에서 주어지는 테스트 케이스 수 (필요 없다면 N만 입력받아도 됨)
        int T = sc.nextInt();
        
        // 최대 범위가 10,000이라고 가정할 때의 DP 배열
        int[] dp = new int[10001];

        // 초기값: 0을 만드는 방법은 아무것도 선택하지 않는 1가지로 설정
        dp[0] = 1;

        // 1. 숫자 1만 사용하여 만드는 경우의 수
        for (int i = 1; i <= 10000; i++) {
            dp[i] += dp[i - 1];
        }

        // 2. 숫자 2를 추가로 사용하여 만드는 경우의 수
        for (int i = 2; i <= 10000; i++) {
            dp[i] += dp[i - 2];
        }

        // 3. 숫자 3을 추가로 사용하여 만드는 경우의 수
        for (int i = 3; i <= 10000; i++) {
            dp[i] += dp[i - 3];
        }

        // 결과 출력
        for (int t = 0; t < T; t++) {
            int n = sc.nextInt();
            System.out.println(dp[n]);
        }
    }
}