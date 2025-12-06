import java.util.*;
import java.io.*;
/**
 *  차례대로 앞에서 추가하는 방식으로 가면 (s -> t) 2의 지수승 시간이 걸리니깐 
 *  반대로 (t -> s)로 가면 a, b에 따라 방법이 1개로 정해지니 n의 시간으로 갈 수 있음 
 */
public class Main {
	static String s, t;
	public static void main(String[] args) throws Exception{
		input();
		while(!s.equals(t) && s.length() <= t.length()) {
			if(t.charAt(t.length()-1)=='A') {
				t = t.substring(0,t.length()-1);
			}else if(t.charAt(t.length()-1)=='B') {
				t = t.substring(0,t.length()-1);
				StringBuffer sb = new StringBuffer(t);
				t = sb.reverse().toString();
			}
			if(s.equals(t)) {
				System.out.print(1);
				return;
			}
		}
		System.out.print(0);
		return;
	}

	private static void input() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s = br.readLine();
		t = br.readLine();
	}

}
