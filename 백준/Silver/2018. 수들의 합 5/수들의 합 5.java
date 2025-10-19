import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        int sum = 0;
        int count = 1;
        
        int sIdx = 0;
        int eIdx = 0;
        
        while(eIdx != N) {
            // 1. sum < N
            // 작을 땐, 큰 값 더해줘야
            if( sum < N ) {
                eIdx ++;
                sum += eIdx;
            }
            // 2. sum > N
            // 클 땐, 작은 값 빼줘야
            else if( sum > N ) {
                sum -= sIdx;
                sIdx ++;
            }
            // 3. 같을 때
            else {
                count++;
                eIdx++;
                sum += eIdx;
            }
        }
        System.out.print(count);
    }
}