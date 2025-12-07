import java.util.*;
import java.io.*;

public class Main {
	static int n, m;
	static int time=1;
	static Integer[] crane;
	static Integer[] boxes;
	static boolean[] visit;
	

	public static void main(String[] args) throws Exception{
		input();
		//크레인이 마지막 인덱스라면 크레인의 값이 마지막 박스보다 작다면 못 실음
		if(crane[0] < boxes[0]) {
			System.out.print(-1);
			return;
		}
		int removeCnt = 0;
		visit = new boolean[m];
		while(removeCnt < boxes.length) {
			int idx=0;
			for(int i=0;i<n;i++) {
				while(idx<boxes.length) {
					if(crane[i]>= boxes[idx] && !visit[idx]) {
						visit[idx]=true;
						removeCnt++;
						idx++;
						break;
					}else {
						idx++;
					}
				}
				if(removeCnt == boxes.length) {
					System.out.print(time);
					return;
				}
			}
			time++;
		}
		System.out.print(time);
		return;
	}


	private static void input() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		crane = new Integer[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			crane[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(crane, Collections.reverseOrder());
		
		m = Integer.parseInt(br.readLine());
		boxes = new Integer[m];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<m;i++) {
			boxes[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(boxes, Collections.reverseOrder());
	}

}
