import java.util.*;
import java.io.*;

// 파라매트릭 서치로 이용해서 풀 수 있음 
// 쉬운 문제!
public class Main {
	static int k, n;
	static int[] lines;
	static long ans, maxLen;
	

	public static void main(String[] args) throws Exception {
		input();
		paramatricSearch();
		System.out.println(ans);
	}


	private static void paramatricSearch() {
		long left = 1; // 1이상 이므로 0이 아닌 1을 왼쪽 기준으로 삼아야 함 
		long right = maxLen; // 가장 큰 랜선을 오른쪽 기준으로 삼음 
		while(left<=right) {
			long mid = (left + right)/2;
			long cnt=0;
			// 랜선 자르기 
			for(int i=0;i<k;i++) {
				cnt+=lines[i]/mid;
			}
			if(cnt >= n) {
				left = mid+1;
				ans = mid;
			}else {
				right = mid-1;
			}
		}
		
	}


	private static void input() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		k = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		lines = new int[k];
		maxLen = -1;
		for(int i=0;i<k;i++) {
			lines[i] = Integer.parseInt(br.readLine());
			maxLen = Math.max(maxLen, lines[i]);
		}
	}

}

