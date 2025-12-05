import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static int[] blocks;
	static int totalRain;

	public static void main(String[] args) throws Exception{
		input();
		calcRain();
		System.out.print(totalRain);
	}

	private static void calcRain() {
		totalRain = 0;
		for(int i=1;i<n-1;i++) {
			int left =0, right = 0;
			for(int j=0;j<i;j++) {
				left = Math.max(left, blocks[j]);
			}
			for(int j=i+1;j<n;j++) {
				right = Math.max(right, blocks[j]);
			}
			int mini = Math.min(left, right);
			if(blocks[i] < mini) {
				totalRain += (mini-blocks[i]);
			}
		}
		
		
	}

	private static void input() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int h = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		blocks = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			blocks[i] = Integer.parseInt(st.nextToken());
		}
		
	}

}
