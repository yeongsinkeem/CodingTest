import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

class Player {
	int level;
	String name;
	
	Player(int level, String name) {
		this.level = level;
		this.name = name;
	}
}

public class Main {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int p = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		// 1. 플레이어 입력 
		List<Player> players = new ArrayList<>();
		
		for(int i = 0; i < p; i++) {
			st = new StringTokenizer(br.readLine());
			int level = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			players.add(new Player(level, name));
		}
		
		// 2. 방 배정
		List<List<Player>> rooms = new ArrayList<>();
		
		// 각 플레이어에 대해 방 배정 
		for(Player newPlayer : players) {
			boolean joined = false;
			for(List<Player> room : rooms) {
				if( room.size() < m) {	
					int firstLevel = room.get(0).level;
					if( newPlayer.level >= firstLevel - 10 && newPlayer.level <= firstLevel + 10) {
						room.add(newPlayer);
						joined = true;
						break;
					}
				}
			}
			// 입장 가능한 방이 없다면 
			if(!joined) {
				List<Player> newRoom = new ArrayList<>();
				newRoom.add(newPlayer);
				rooms.add(newRoom);
			}
		}
		
		// 3. 출력 
		// 방 안에는 여러 명의 플레이어 존재 
		for(List<Player> room : rooms) {
			if(room.size() == m) {
				// 게임 중 
				System.out.println("Started!");
			}
			else {
				// 대기 중 
				System.out.println("Waiting!");
			}
			// 닉네임 알파벳 순 정렬 
			room.sort(Comparator.comparing(p1 -> p1.name));
			for(Player pl : room) {
				System.out.println(pl.level + " " + pl.name);
			}
		}

	}

}