import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		String[] arr = new String[2];
		arr[0] = "SK";
		arr[1] = "CY";
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int a = N / 3;
		int b = N % 3;
		
		// 짝수
		// 나머지가 1 -> 상근 
		if( a % 2 == 0 ) {
			if( b == 1 ) {
				System.out.println("SK");
			}
			else {
				System.out.println("CY");
			}
		}
		
		// 홀수 
		else {
			if( b == 1 ) {
				System.out.println("CY");
			}
			else {
				System.out.println("SK");
			}
		}
		
	}
	
}