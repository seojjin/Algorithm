import java.util.*;
import java.io.*;

public class Main {

	static int n, m;
	static int[] lights;
	
	public static void main(String[] args) throws Exception {
		input();
		int minimuL = Math.max(lights[0], n-lights[m-1]);
		for(int i=1;i<m;i++) {
			minimuL = Math.max(minimuL, (lights[i]-lights[i-1]+1)/2);
		}
		System.out.print(minimuL);
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		lights = new int[m];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<m;i++) {
			lights[i] = Integer.parseInt(st.nextToken());
		}
	}

}
