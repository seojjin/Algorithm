import java.util.*;
import java.io.*;

public class Main {
	static int n, m;
	static int[] arr, sumArr;
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		input();
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			sb.append(sumArr[n2]-sumArr[n1-1]).append("\n");
		}
		System.out.println(sb);
	}

	private static void input() throws Exception {
		n = Integer.parseInt(br.readLine());
		arr = new int[n+1];
		sumArr = new int[n+2];
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(i>=1) sumArr[i] = sumArr[i-1]+arr[i];
			else sumArr[i] = arr[i];
		}
		m = Integer.parseInt(br.readLine());
	}

}
