import java.util.*;
import java.io.*;

public class Main {
	static int n, m;
	static int[][] map;
	static boolean[][][] visit;
	static int answer;

	public static void main(String[] args) throws Exception{
		input();
		answer = -1;
		bfs();
		System.out.print(answer);
	}
	static int[] dr = {-1, 1, 0, 0 };
	static int[] dc = {0, 0, -1, 1};

	private static void bfs() {
		visit = new boolean[n][m][2];
		visit[0][0][0] = true;
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {0,0,1,0});
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			int curR = temp[0];
			int curC = temp[1];
			int curDist = temp[2];
			int breakWall = temp[3];
			if(curR==n-1 && curC==m-1) {
				answer = curDist;
				return;
			}
			for(int i=0;i<4;i++) {
				int nr = curR + dr[i];
				int nc = curC + dc[i];
				if(isin(nr, nc)) {
					if(map[nr][nc]==0 && !visit[nr][nc][breakWall]) {
						q.add(new int[] {nr, nc, curDist+1, breakWall});
						visit[nr][nc][breakWall] = true;
					}else if(map[nr][nc]==1 && breakWall==0 && !visit[nr][nc][breakWall]) {
						q.add(new int[] {nr, nc, curDist+1, 1});
						visit[nr][nc][1] = true;
					}
				}
			}
		}
	}

	private static boolean isin(int nr, int nc) {
		return nr>=0 && nr <n && nc>=0 && nc<m;
	}

	private static void input() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		for(int i=0;i<n;i++) {
			String temp = br.readLine();
			for(int j=0;j<m;j++) {
				map[i][j] = temp.charAt(j)-'0';; 
			}
		}
		
	}

}
