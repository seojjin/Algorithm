import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static int[][] eggs;
	static int ans;
	static boolean[] isCrack;

	public static void main(String[] args) throws Exception{
		input();
		backtrack(0, 0);
		System.out.print(ans);
	}

	private static void backtrack(int now, int crackedEgg) {
		if(now==n) {
			ans = Math.max(crackedEgg, ans);
			return;
		}
		
		
		if(isCrack[now]) {
			backtrack(now+1, crackedEgg);
			return;
		}
		
		boolean hit = false;
		for(int i=0;i<n;i++) {
			if(isCrack[i]) continue;
			if(i==now) continue;
			hit = true;
			
			eggs[now][0]-=eggs[i][1];
			eggs[i][0]-=eggs[now][1];
			//깨진지 체크
			boolean brokeNow = false;
			boolean brokeI = false;
			if(eggs[i][0]<=0) {
				isCrack[i]=true;
				crackedEgg++;
				brokeI=true;
			}
			if(eggs[now][0]<=0) {
				isCrack[now]=true;
				crackedEgg++;
				brokeNow=true;
			}
			backtrack(now+1, crackedEgg);
			// 다시 복구 
			eggs[now][0]+=eggs[i][1];
			eggs[i][0]+=eggs[now][1];
			if(brokeI) {
				isCrack[i]=false;
				crackedEgg--;
			}
			if(brokeNow) {
				isCrack[now]=false;
				crackedEgg--;
			}
		}
		// 깰 수 없으면 다음걸로 넘김 
		if(!hit) {
			backtrack(now + 1, crackedEgg);
		}
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		eggs = new int[n][2];
		isCrack = new boolean[n];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			eggs[i][0] = Integer.parseInt(st.nextToken());
			eggs[i][1] = Integer.parseInt(st.nextToken());
		}
		
	}

}
