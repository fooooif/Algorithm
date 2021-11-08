package dp.moduler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_11726 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
//        int n = 9;
        int[] dp = new int[n+3];
        dp[0] = 1;
        for(int i = 0 ; i < n+1; i++){

            dp[i+2] += dp[i]%10007;
            dp[i+1] += dp[i]%10007;

        }
        System.out.println(dp[n]%10007);
    }
}
