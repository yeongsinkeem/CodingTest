import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		// 1. person 타입의 배열 생성 
		ArrayList<Person> arrLst = new ArrayList<Person>();
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			arrLst.add(new Person(w, h));
		}
		
		// 2. 순회하면서 비교 
		for(Person firstP : arrLst) {
			int count = 0;
			for(Person secondP: arrLst) { 
				if( firstP.weight < secondP.weight && firstP.height < secondP.height ) {
					count++;
				}
			}
			System.out.print((count + 1) + " ");
		}
		
	}
}

class Person {
	public int weight;
	public int height;
	
	public Person(int weight, int height) {
		this.weight = weight;
		this.height = height;
	}
}