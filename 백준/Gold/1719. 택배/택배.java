import java.util.*;
import java.io.*;

public class Main {
	static int n,m;
	static int[][] map, firstGo;
	static final int INF = 987654321;
	

	public static void main(String[] args) throws Exception{
		input();
		floyd();
	}


	private static void floyd() {
		for(int k=1;k<=n;k++) {
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					if(map[i][j] > map[i][k] + map[k][j]) {
						map[i][j] = map[i][k] + map[k][j];
						firstGo[i][j] = firstGo[i][k];
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(firstGo[i][j]==0) {
					sb.append("-").append(" ");
				}else {
					sb.append(firstGo[i][j]).append(" ");
				}
			}
			sb.append("\n");
		}
		
		System.out.print(sb);
		
	}


	private static void input() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n+1][n+1];
		firstGo = new int[n+1][n+1];
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(i==j) continue;
				map[i][j] = 987654321;
			}
		}
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			map[n1][n2] = time;
			map[n2][n1] = time;
			firstGo[n1][n2] = n2;
			firstGo[n2][n1] = n1;
		}
	}

}
