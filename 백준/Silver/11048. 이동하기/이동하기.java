import java.util.*;
import java.io.*;

public class Main {
	static int n,m;
	static int[][] map, dp;
	static int[] dr = {1, 0, 1};
	static int[] dc = {0, 1 ,1};

	public static void main(String[] args) throws Exception{
		input();
		dp[0][0] = map[0][0];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				for(int k=0;k<3;k++) {
					int nr = i+dr[k];
					int nc = j+dc[k];
					if(isin(nr, nc)) {
						dp[nr][nc] = Math.max(dp[nr][nc], dp[i][j]+map[nr][nc]);
					}
				}
				
			}
		}
		System.out.println(dp[n-1][m-1]);
	}

	private static boolean isin(int nr, int nc) {
		return nr>=0 && nc>=0 && nr<n && nc<m;
	}

	private static void input() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		dp = new int[n][m];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
	}

}
