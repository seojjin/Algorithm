import java.util.*;
import java.io.*;

public class Main {
	static int s, c;
	static long ans, total;
	static int[] springOnions;

	public static void main(String[] args) throws Exception {
		input();
		paramatric();
		System.out.println(ans);
	}

	private static void paramatric() {
		ans = 0;
		int left = 1;
		int right = springOnions[springOnions.length-1];
		while(left<=right) {
			int mid = (left + right)/2;
			long chickenCnt=0;
			for(int i=0;i<s;i++) {
				chickenCnt += springOnions[i]/mid;
			}
			if(chickenCnt >= c) {
				left = mid+1;
				ans = total - (long)c * mid;
			}else {
				right = mid-1;
			}
		}
		
	}

	private static void input() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		s = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		springOnions = new int[s];
		total = 0;
		for(int i=0;i<s;i++) {
			springOnions[i] = Integer.parseInt(br.readLine());
			total+= springOnions[i];
		}
		Arrays.sort(springOnions);
	}

}
