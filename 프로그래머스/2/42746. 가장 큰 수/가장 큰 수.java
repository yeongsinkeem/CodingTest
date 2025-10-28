import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        // 1. int형을 넘을 수 있기 때문에 String으로 형변환
        String[] numStrs = new String[numbers.length];
        for(int i = 0; i < numStrs.length; i++) {
            numStrs[i] = String.valueOf(numbers[i]);
        }
        
        // 2. Comparator 활용한 정렬
        Arrays.sort(numStrs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2 );
            }
        });
        
        if( numStrs[0].equals("0") ) return "0";
        
        StringBuilder sb = new StringBuilder();
        
        for(String s : numStrs) {
            sb.append(s);
        }
        
        /*
        if( Integer.parseInt(sb) == 0 ) {
            return "0";
        }
        */
        
        return sb.toString();
    }
}