import java.util.*;
import java.io.*;

public class Main {
	static char[][] map;
	static int n;
	static int[] heart, body;

	public static void main(String[] args) throws Exception {
		input();
		heart = new int[2];
		body = new int[5];
		// 심장 찾기 
		OUT: for(int i=1;i<n-1;i++) {
			for(int j=1;j<n-1;j++) {
				if(map[i][j]=='*') {
					boolean t = isHeart(i, j);
					if(t) {
						heart[0] = i;
						heart[1] = j;
						break OUT;
					}
				}
			}
		}
		
		// 왼쪽 팔
		int nc=heart[1]-1;
		while(true) {
			if(nc>=0 && map[heart[0]][nc]=='*') {
				body[0]++;
				nc--;
			}else {
				break;
			}
		}
		
		// 오른쪽 팔
		nc=heart[1]+1;
		while(true) {
			if(nc<n && map[heart[0]][nc]=='*') {
				body[1]++;
				nc++;
			}else {
				break;
			}
		}
		
		
		int rWaist = heart[1];
		// 허리 
		int nr=heart[0]+1;
		while(true) {
			if(nr<n && map[nr][heart[1]]=='*') {
				body[2]++;
				rWaist = nr;
				nr++;
			}else {
				break;
			}
		}
		
		// 왼쪽 다리 
		int startRow = rWaist+1;
		int startCol = heart[1]-1;
		while(true) {
			if(startRow<n && map[startRow][startCol]=='*') {
				body[3]++;
				startRow++;
			}else {
				break;
			}
		}
		
		// 오른쪽 다리 
		startRow = rWaist+1;
		startCol = heart[1]+1;
		while(true) {
			if(startRow<n && map[startRow][startCol]=='*') {
				body[4]++;
				startRow++;
			}else {
				break;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(heart[0]+1).append(" ").append(heart[1]+1).append("\n");
		for(int i=0;i<5;i++) {
			sb.append(body[i]).append(" ");
		}
		System.out.print(sb);
	}

	private static boolean isHeart(int i, int j) {
		if(map[i-1][j]!='*') return false;
		if(map[i][j-1]!='*') return false;
		if(map[i][j+1]!='*') return false;
		if(map[i+1][j]!='*') return false;
		return true;
		
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new char[n][n];
		for(int i=0;i<n;i++) {
			String temp = br.readLine();
			for(int j=0;j<n;j++) {
				map[i][j] = temp.charAt(j);
			}
		}
		
	}

}
