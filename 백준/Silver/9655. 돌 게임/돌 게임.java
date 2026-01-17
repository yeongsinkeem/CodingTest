import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 돌의 개수 N 입력
        int N = sc.nextInt();
        
        // N이 홀수이면 상근(SK), 짝수이면 창영(CY)
        if (N % 2 == 1) {
            System.out.println("SK");
        } else {
            System.out.println("CY");
        }
        
        sc.close();
    }
}