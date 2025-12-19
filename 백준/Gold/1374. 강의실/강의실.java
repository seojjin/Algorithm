import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static int[][] classes;

	public static void main(String[] args) throws Exception{
		input();
		// greedy로 먼저 들어가는 시작하는 강의 먼저 처리 
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1]-b[1]);
		int roomNum = 1;
		pq.add(new int[] {roomNum, classes[0][2]}); // 룸 번호, 강의 종료 시간 
		for(int i=1;i<n;i++) {
			if (pq.peek()[1]<=classes[i][1]) {
				int[] room = pq.poll();
				pq.add(new int[] {room[0], classes[i][2]}); 
			}else {
				pq.add(new int[] {++roomNum, classes[i][2]}); 
			}
			
			
		}
		System.out.print(roomNum);

	}

	private static void input() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		classes = new int[n][3];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			classes[i][0] = Integer.parseInt(st.nextToken()); // 강의 번호
			classes[i][1] = Integer.parseInt(st.nextToken()); // 강의 시작 시간 
			classes[i][2] = Integer.parseInt(st.nextToken()); // 강의 종료 시간 
		}
		Arrays.sort(classes, (a,b) -> a[1]-b[1]);
		
	}

}
