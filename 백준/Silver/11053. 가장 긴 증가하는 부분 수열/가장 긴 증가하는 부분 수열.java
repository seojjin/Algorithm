import java.io.*;
import java.util.*;
import static java.lang.Integer.parseInt;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[n+1];
        for(int i=1;i<=n;i++){
            nums[i] = parseInt(st.nextToken());
        }

        int[] dp=new int[n+1];

        dp[0] = 0;
        dp[1] = 1;
        int res = 1;
        for(int i=2;i<=n;i++){
            dp[i] = 1;
            for(int j=1;j<=i-1;j++){
                if(nums[i] > nums[j] && dp[i] <= dp[j]){
                    dp[i] = dp[j]+1;
                }
            }
            res = Math.max(res, dp[i]);
        }
        System.out.println(res);

    }
}
