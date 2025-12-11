
import java.util.*;
import java.io.*;
import static java.lang.Integer.parseInt;
public class Main {
	static int n, m;
	static int[][] map;
	static boolean[][][] isVisited;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = parseInt(st.nextToken());
		m = parseInt(st.nextToken());
		map = new int[n+1][m+1];
		isVisited = new boolean[n+1][m+1][2]; // 벽을 부수고 안부수고를 고려해서 방문처리를 해야해
		for(int i=1;i<=n;i++) {
			char[] temp = br.readLine().toCharArray();
			for(int j=1;j<=m;j++) {
				map[i][j] = temp[j-1]-'0';
			}
		}
		int res = bfs(1,1);
		System.out.println(res);

	}
	
	public static int bfs(int r, int c){
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};	
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.add(new int[] {r, c, 1, 0});
		isVisited[r][c][0] = true;
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			int cnt = temp[2]; // 이동한 거리
			int state = temp[3]; //벽을 부섰는지 안부셨는지 (이전 기수에)
			if(temp[0]==n && temp[1]==m) {
				return cnt;
			}
			for(int i=0;i<4;i++) {
				int nr = temp[0]+dr[i];
				int nc = temp[1]+dc[i];
				if(nr>=1 && nc>=1 && nr<=n && nc<=m && !isVisited[nr][nc][state]) { // 범위 안에 들어오고 방문하지 않았다면
					if(map[nr][nc]==0) {
						isVisited[nr][nc][state] = true;
						q.add(new int[] {nr, nc, cnt+1, state}); // 전기수 반영 state
					}else if(map[nr][nc]==1 && state==0) { // 방문하려는 곳이 1인데 아직 벽을 부수지 않았음
						isVisited[nr][nc][state] = true;
						q.add(new int[] {nr, nc, cnt+1, 1});
					}else if(map[nr][nc]==1 && state==1){// 방문하려는 곳이 1인데 이미 벽을 부쉈으면 할 도리가 없음
						continue; // 다음거 진행
					} 
					
				}
			}
		}
		
		// 그냥 q에 든게 없다면 
		return -1;
		
	}

}
