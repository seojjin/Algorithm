import java.util.*;
import java.io.*;

public class Main {
	static int n, m, fuel, sr, sc, plusFuel;
	static int[][] map;
	static List<Guest> guests;
	static Guest targetGuest;
	
	static class Guest implements Comparable<Guest>{
		int cr;
		int cc;
		int tr;
		int tc;
		
		public Guest(int cr, int cc, int tr, int tc) {
			this.cr = cr;
			this.cc = cc;
			this.tr = tr;
			this.tc = tc;
		}

		@Override
		public int compareTo(Guest o) {
			if(this.cr==o.cr) {
				return this.cc-o.cc;
			}
			return this.cr-o.cr;
		}
	}

	public static void main(String[] args) throws Exception{
		input();
		for(int i=0;i<m;i++) {
			select();
			if(fuel<0 || targetGuest==null) {
				System.out.print(-1);
				return;
			}
			plusFuel = 0;
			if(!driveToTarget()){
				System.out.print(-1);
				return;
			}
			if(fuel<0) {
				System.out.print(-1);
				return;
			}
			fuel += plusFuel;
			sr = targetGuest.tr;
			sc = targetGuest.tc;
		}
		System.out.print(fuel);
	}

	private static boolean driveToTarget() {
		Queue<int[]> q = new ArrayDeque<>();
		boolean[][] visit = new boolean[n+1][n+1];
		visit[targetGuest.cr][targetGuest.cc] = true;
		q.add(new int[] {targetGuest.cr, targetGuest.cc, 0});
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			int dist = temp[2];
			if(temp[0]== targetGuest.tr&& temp[1]==targetGuest.tc) {
				fuel-=dist;
				plusFuel = dist*2;
				return true;
			}
			for(int i=0;i<4;i++) {
				int nr = temp[0]+dr[i];
				int nc = temp[1]+dc[i];
				if(isin(nr, nc) && map[nr][nc]!=1 &&!visit[nr][nc]) {
					visit[nr][nc] = true;
					q.add(new int[] {nr, nc, dist+1});
				}
			}
		}
		return false;
		
	}

	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	private static void select() {
		Queue<int[]> q = new ArrayDeque<>();
		PriorityQueue<Guest> nearGuest = new PriorityQueue<>();
		boolean[][] visit = new boolean[n+1][n+1];
		visit[sr][sc] = true;
		q.add(new int[] {sr, sc, 0});
		int minDist=Integer.MAX_VALUE;
		
		if(map[sr][sc] >= 2) {
			targetGuest = guests.get(map[sr][sc] - 2);
			map[targetGuest.cr][targetGuest.cc] = 0;
			return;
		}
		
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			int dist = temp[2];
			if (dist > minDist) break;

			for (int i = 0; i < 4; i++) {
			    int nr = temp[0] + dr[i];
			    int nc = temp[1] + dc[i];

			    // 범위 밖 or 벽 or 이미 방문 → 스킵
			    if (!isin(nr, nc) || map[nr][nc] == 1 || visit[nr][nc]) continue;

			    // 이동 가능 (빈칸이든 손님칸이든)
			    visit[nr][nc] = true;
			    q.add(new int[]{nr, nc, dist + 1});

			    // 손님이면 후보로만 기록
			    if (map[nr][nc] >= 2) {
			        if (dist + 1 <= minDist) {
			            minDist = dist + 1;
			            nearGuest.add(guests.get(map[nr][nc] - 2));
			        }
			    }
			}
		}
		
		// 손님을 한 명도 못 찾음
	    if (nearGuest.isEmpty()) {
	        targetGuest = null;
	        return;
	    }

	    // 최종 선택
	    targetGuest = nearGuest.poll();
	    fuel -= minDist;
	    map[targetGuest.cr][targetGuest.cc] = 0;
		
	}

	private static boolean isin(int nr, int nc) {
		return nr>0 && nc>0 && nr<=n && nc<=n;
	}

	private static void input() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		fuel = Integer.parseInt(st.nextToken());
		map = new int[n+1][n+1];
		for(int i=1;i<=n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=n;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		sr = Integer.parseInt(st.nextToken());
		sc = Integer.parseInt(st.nextToken());
		guests = new ArrayList<>();
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine()); // 게스트는 2번부터 시작 
			int cr = Integer.parseInt(st.nextToken());
			int cc = Integer.parseInt(st.nextToken());
			int tr = Integer.parseInt(st.nextToken());
			int tc = Integer.parseInt(st.nextToken());
			guests.add(new Guest(cr, cc, tr, tc));
			map[cr][cc] = i+2;
		}
	}

}
