import java.io.*;
import java.util.*;
import static java.lang.Integer.parseInt;
public class Main {
	static int n;
	static int[][] map;
	static boolean[][] isVisited;
	static class Node implements Comparable<Node>{
		int r;
		int c;
		int cost;
		public Node(int r, int c, int cost) {
			super();
			this.r = r;
			this.c = c;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
		
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int index = 0;
		while(true) {
			index++;
			st = new StringTokenizer(br.readLine());
			n = parseInt(st.nextToken());
			if(n==0) break;
			map = new int[n][n];
			isVisited = new boolean[n][n];
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine()); 
				for(int j=0;j<n;j++) {
					map[i][j] = parseInt(st.nextToken());
				}
			}
			
			int res = dijkstra(0,0);
			sb.append("Problem "+ index +": "+res).append("\n");
		}
		System.out.println(sb);

	}

	private static int dijkstra(int r, int c) {
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.add(new Node(r, c, map[r][c]));
		isVisited[r][c] = true;
		while(!q.isEmpty()) {
			Node temp = q.poll();
			if(temp.r==n-1 && temp.c==n-1) {
				return temp.cost;
			}
			for(int i=0;i<4;i++) {
				int nr = temp.r + dr[i];
				int nc = temp.c + dc[i];
				if(nr>=0 && nc>=0 && nr<n && nc<n && !isVisited[nr][nc]) {
					q.add(new Node(nr, nc, temp.cost+map[nr][nc]));
					isVisited[nr][nc] = true;
				}
				
			}
		}
		return -1;
		
	}

}
