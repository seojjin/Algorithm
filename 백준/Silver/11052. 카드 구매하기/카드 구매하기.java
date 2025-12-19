import java.util.*;
import java.io.*;

public class Main{
	static int n;
	static int[] P;
	static int[] dp;

	public static void main(String[] args) throws Exception {
		input();
		dp = new int[n+1];
		for(int i=1;i<=n;i++) {
			dp[i] = P[i];
			for(int j=1;j<i;j++) {
				dp[i] = Math.max(dp[i], dp[j] + dp[i-j]);
			}
		}
		System.out.print(dp[n]);
	}

	private static void input() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		P= new int[n+1];
		for(int i=1;i<=n;i++) {
			P[i] = Integer.parseInt(st.nextToken());
		}
		
	}

}
