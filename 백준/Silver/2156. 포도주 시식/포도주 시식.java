import java.util.*;
import java.io.*;
public class Main {

	static int n;
	static int[] wines;
	
	public static void main(String[] args) throws Exception{
		input();
		// dp 초기화 
		int[][] dp = new int[n][3];
		for(int i=0;i<n;i++) {
			Arrays.fill(dp[i], 0);
		}
		
		dp[0][1] = wines[0];
		dp[0][2] = wines[0];
		
		
		for(int i=1;i<n;i++) {
			// 이번것 마시지 않음 
			dp[i][0] = Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][2]));
			// 이번거만 마심
			dp[i][1] = dp[i-1][0] + wines[i]; 
			// 이전 + 이번 
			dp[i][2] = dp[i-1][1] + wines[i]; 
		}
		
		int ans = Math.max(dp[n-1][0], Math.max(dp[n-1][1], dp[n-1][2]));
		System.out.println(ans);
	}
	
	public static void input() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		wines = new int[n];
		for(int i=0;i<n;i++) {
			wines[i] = Integer.parseInt(br.readLine());
		}
	}

}
