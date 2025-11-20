import java.util.*;

class Solution {
    
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Set<String> set = new LinkedHashSet<>();
        
        if( cacheSize == 0 ) return cities.length * 5;
        
        // 대소문자 구분 x
        for(int i = 0; i < cities.length; i++) {
            cities[i] = cities[i].toLowerCase();
        }
        
        for( String city : cities ) {
            if( set.contains( city ) ) {
                answer += 1;
                set.remove( city );
                set.add( city );
            }
            
            // 3. set에 없다면 
            else {
                answer += 5;
                
                // 4. cache가 꽉 찼다면 가장 오래된 요소 삭제
                if( set.size() == cacheSize ) {
                    Iterator<String> iterator = set.iterator();
                    if (iterator.hasNext()) {
                        String oldestCity = iterator.next();
                        set.remove(oldestCity); 
                    }
                }
                // 5. 새로운 요소 등록 
                set.add( city );
            }
        }
        
        return answer;
    }
}