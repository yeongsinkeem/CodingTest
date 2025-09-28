import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static class Word {
		int cnt;
		int wordlen;
		String name;
		
		public Word(int cnt, int wordlen, String name) {
			this.cnt = cnt;
			this.wordlen = wordlen;
			this.name = name;
		}
	}
	
	static class WordComparator implements Comparator<Word> {
		@Override
		public int compare(Word o1, Word o2) {
			// 1. 빈도 
			if (o1.cnt != o2.cnt) {
				return o2.cnt - o1.cnt;
			} 
			// 2. 단어 길이 
			else if( o1.wordlen != o2.wordlen){
				return o2.wordlen - o1.wordlen;
			}
			// 3. 알파벳 
			else return o1.name.compareTo(o2.name);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		
		// 1. 단어 중복 및 cnt 체크 
		Map<String, Word> map = new HashMap<>();
		
		for(int i = 0; i < N; i++) {
			String inputWord = br.readLine();
			
			// 길이가 M 이상인 것에 한해 
			if (inputWord.length() >= M) {
				// 해당 요소 가지고 있다면 
				if(map.containsKey(inputWord)) {
					map.get(inputWord).cnt++;
				}
				else {
					map.put(inputWord, new Word(1, inputWord.length(), inputWord));
				}
			}
		}
		
		List<Word> words = new ArrayList<>(map.values());
		Collections.sort(words, new WordComparator());
		
		
		for(Word w : words) {
			sb.append(w.name).append("\n");
		}
		System.out.print(sb);
	}
}