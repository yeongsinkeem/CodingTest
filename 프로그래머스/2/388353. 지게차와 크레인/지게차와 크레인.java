import java.util.*;

class Solution {
    char[][] map;
    int N, M;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public int solution(String[] storage, String[] requests) {
        N = storage.length;
        M = storage[0].length();
        
        // 1. 패딩을 포함한 맵 생성 (상하좌우 +1씩 총 +2)
        map = new char[N + 2][M + 2];
        for (int i = 0; i < N + 2; i++) {
            Arrays.fill(map[i], '0'); // 모두 빈 공간('0')으로 초기화
        }

        // 2. 원래 storage 데이터를 가운데에 복사
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i + 1][j + 1] = storage[i].charAt(j);
            }
        }

        // 3. 요청(requests) 처리
        for (String req : requests) {
            if (req.length() == 1) {
                // 지게차: 외부에서 접근 가능한 것만 제거
                jigae(req.charAt(0));
            } else {
                // 크레인: 전체에서 해당 문자 모두 제거
                crain(req.charAt(0));
            }
        }

        // 4. 남은 컨테이너 개수 세기
        int count = 0;
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= M; j++) {
                if(map[i][j] != '0') count++;
            }
        }
        
        return count;
    }

    // 지게차 :  BFS
    public void jigae(char target) {
        boolean[][] visited = new boolean[N + 2][M + 2];
        Queue<int[]> q = new LinkedList<>();
        List<int[]> toRemove = new ArrayList<>();

        // 항상 (0,0)은 빈 공간이므로 여기서 출발
        q.add(new int[]{0, 0});
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = curr[0] + dx[i];
                int ny = curr[1] + dy[i];

                // 경계 벗어나지 않고 미방문이라면 
                if (nx >= 0 && nx < N + 2 && ny >= 0 && ny < M + 2 && !visited[nx][ny]) {
                    // 계속 안으로 이동
                    if( map[nx][ny] == '0' ) {
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx, ny});
                    } else if( map[nx][ny] == target ) {
                        visited[nx][ny] = true;
                        toRemove.add(new int[]{nx, ny});
                    }
                }
            }
        }

        // 찾은 물건들을 한꺼번에 빈 공간('0')으로 변경
        for (int[] pos : toRemove) {
            map[pos[0]][pos[1]] = '0';
        }
    }

    // 크레인 : 모든 위치 확인해서 같은 문자 제거
    public void crain(char target) {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (map[i][j] == target) {
                    map[i][j] = '0';
                }
            }
        }
    }
}