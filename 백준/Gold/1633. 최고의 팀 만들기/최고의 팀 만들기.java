import java.util.*;
import java.io.*;

public class Main
{
    static int n;
    static int[][] players;
    static int[][][] dp;
    static int answer;
    
	public static void main(String[] args) throws Exception{
		input();
		answer = 0;
		
		// 1. 백을 선택
		// 2. 흑을 선택 
		// 3. 둘다 선택하지 않음
		dp[0][1][0] = players[0][0]; // 첫번째 플레이어 백 
		dp[0][0][1] = players[0][1]; // 첫번째 플레이어 흑
		int max = -1;
		int max_idx = 15;
		for(int i=1;i<n;i++){
		    for(int j=0;j<=max_idx;j++){
		        for(int k=0;k<=max_idx;k++){
		            int temp1 = 0;
		            int temp2 = 0;
		            if(j>0){
		                temp1 = dp[i-1][j-1][k] + players[i][0];
		            }
		            if(k>0){
		                temp2 = dp[i-1][j][k-1] + players[i][1];
		            }
		            dp[i][j][k] = Math.max(dp[i-1][j][k], Math.max(temp1, temp2));
		        
		            if(j==max_idx && k==max_idx){
		                max = Math.max(max, dp[i][j][k]);
		            }
		        }
		    }
		}
		System.out.println(max);
	}
	
	
	
	public static void input() throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
        players = new int[1001][2];
        dp = new int[1001][16][16];
        n=0;
	    while(true){
	        String line = br.readLine();
            if(line == null) break;     // EOF 안전 처리
            st = new StringTokenizer(line);
            if(!st.hasMoreTokens()) break;
	        int n1 = Integer.parseInt(st.nextToken());
	        int n2 = Integer.parseInt(st.nextToken());
	        players[n][0] = n1; // 백
	        players[n++][1] = n2; // 흑
	    }
	    
	    
	}
}