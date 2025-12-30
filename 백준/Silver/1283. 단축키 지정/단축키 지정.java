import java.io.*;
import java.util.*;

public class Main {
    static Set<Character> used = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            String[] words = line.split(" ");
            boolean found = false;

            // 1. 각 단어의 첫 글자 확인
            int currentPos = 0;
            for (int j = 0; j < words.length; j++) {
                char first = Character.toLowerCase(words[j].charAt(0));
                if (!used.contains(first)) {
                    used.add(first);
                    found = true;
                    // 결과 출력: 해당 단어의 첫 글자에 [] 씌우기
                    printWithBracket(words, j, 0); 
                    break;
                }
            }

            // 2. 1 실패 시, 전체 글자를 왼쪽부터 확인
            if (!found) {
                for (int j = 0; j < line.length(); j++) {
                    char c = line.charAt(j);
                    if (c != ' ' && !used.contains(Character.toLowerCase(c))) {
                        used.add(Character.toLowerCase(c));
                        found = true;
                        // 결과 출력: line의 j번째 글자에 [] 씌우기
                        System.out.println(line.substring(0, j) + "[" + line.charAt(j) + "]" + line.substring(j + 1));
                        break;
                    }
                }
            }

            // 3. 어떤 글자도 단축키 X
            if (!found) {
                System.out.println(line);
            }
        }
    }

    // 단어 배열에서 특정 단어(wordIdx)의 특정 글자(charIdx)에 대괄호를 씌워 출력하는 함수
    private static void printWithBracket(String[] words, int wordIdx, int charIdx) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if (i == wordIdx) {
                String w = words[i];
                sb.append(w.substring(0, charIdx)).append("[").append(w.charAt(charIdx)).append("]").append(w.substring(charIdx + 1));
            } else {
                sb.append(words[i]);
            }
            if (i < words.length - 1) sb.append(" ");
        }
        System.out.println(sb.toString());
    }
}